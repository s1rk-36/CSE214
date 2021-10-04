/**
 * Kristian Hajredinaj
 * 113367328
 * Recitation 4
 */


public class CargoShip {

    private CargoStack[] stacks;
    private int maxHeight;
    private double maxWeight;
    private double totalWeight = 0;
    private int numStacks;

    /**
     *
     * @param numStacks
     * the number of stacks for cargo
     * @param initMaxHeight
     * the height of a cargo stack
     * @param initMaxWeight
     * the weight the ship can hold
     * @throws IllegalArgumentException
     * if the any of the params are invalid
     */
    public CargoShip(int numStacks, int initMaxHeight, double initMaxWeight)
            throws IllegalArgumentException {
        if (numStacks <= 0 || initMaxHeight <= 0 || initMaxWeight <= 0) {
            throw new IllegalArgumentException();
        } else {
            stacks = new CargoStack[numStacks];
            maxHeight = initMaxHeight;
            maxWeight = initMaxWeight;
            this.numStacks = numStacks;
        }
    }

    /**
     *
     * @param cargo
     * cargo object to be pushed
     * @param stack
     * the index of the stack
     * @throws IllegalArgumentException
     * if the stack is full or the ship is overweight
     * or the cragostrength rule is violated or
     *  if the stack is full
     */
    public void pushCargo(Cargo cargo, int stack) throws IllegalArgumentException {
        try {
            if (cargo == null || (stack < 1 || stack > stacks.length)) {
                throw new IllegalArgumentException();
            } else if (stack + 1 > maxHeight) {
                throw new FullStackException();
            } else if (cargo.getWeight() + totalWeight > maxWeight) {
                throw new ShipOverweightException();
            } else if (totalWeight > maxWeight &&
                    (stacks[stack - 1].peek().getStrength().getValue() < cargo.getStrength().getValue())) {
                throw new CargoStrengthException();
            } else {

                CargoStack temp = new CargoStack();
                temp.push(cargo);
                stacks[stack - 1] = temp;
                totalWeight += temp.peek().getWeight();

            }
        } catch (IllegalArgumentException | CargoStrengthException |
                ShipOverweightException | FullStackException e) {
            System.out.println(e);
        }
    }

    /**
     *
     * @param stack
     * the index of the cargo to be popped
     * @return
     * the cargo that is popped
     */
    public Cargo popCargo(int stack) {
        try {
            if (stack < 0 || stack > stacks.length) {
                throw new IllegalArgumentException();
            } else if (stacks[stack - 1] == null) {
                throw new EmptyStackException();
            } else {
                totalWeight -= stacks[stack - 1].peek().getWeight();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("No cargo");
        }
        catch (EmptyStackException e){
            System.out.println(e);
        }
        return stacks[stack - 1].pop();
    }

    /**
     *
     * @param name
     * finds and prints info of cargo based on name
     * @throws EmptyStackException
     * if the stack is empty
     */
    public void finAndPrint(String name) throws EmptyStackException {

        String str = ("Stack\tDepth\tWeight\tStrength\n");
        System.out.print(str);
        System.out.println("=".repeat(35));

        int count = 0;
        double totalWeight = 0;
        int occ = 0;

        for (int i = 0; i < maxHeight; i++) {
            stacks[i] = (CargoStack) stacks[i].clone();
            if (stacks[i] == null)
                continue;
            for (int j = 0; j < maxHeight; j++) {
                if (stacks[i].size() == 0){
                    break;
                } else {
                    String tempCargo = stacks[i].peek().getName();
                    if (tempCargo.equals(name)) {
                        count++;
                        totalWeight += stacks[i].peek().getWeight();
                        occ++;
                        System.out.println(i + " |\t" + (stacks[i].size() - 1) +
                                " |\t" + stacks[i].peek().getWeight() + " |\t" + stacks[i].pop().getStrength());
                    }
                }
            }
        }
        if (occ == 0) {
            System.out.print("Couldn't find cargo '" + name + "'");
        } else {
            System.out.println("Total Count: " + count);
            System.out.println("Total Weight: " + totalWeight);
        }
    }

    /**
     * prints the info of the ship
     * @param ship
     * ship object
     */
   public void PrintShip(CargoShip ship){

//        System.out.println();
//        CargoShip ship1 = new CargoShip(numStacks, maxHeight, maxWeight);
//        for (int i = 0; i < numStacks; i++){
//            ship1.stacks[i] = stacks[i];
//        }
//        for (int i = 1; i <= numStacks; i++) {
//            while(!(ship1.stacks[i].isEmpty())){
//                ship1.pushCargo(ship.popCargo(i), i);
//                System.out.println(" ".repeat(4) +
//                        ship1.popCargo(i).getStrength().getValue());
//            }
//        }
//        System.out.println("\\=" + "|=====|".repeat(numStacks) + "=/");
//        for (int j = 1; j <= numStacks; j++) {
//            if (j == 1) {
//                System.out.print(" \\   " + j);
//            } else if (j < numStacks)
//                System.out.print("     " + j);
//            else {
//                System.out.println("     " + j + "   /");
//                System.out.println("\\" + "-".repeat(6 * j) + "/");
//            }
//        }
        System.out.println("Total Weight = " + totalWeight + " / " + maxWeight);
//
   }

}


