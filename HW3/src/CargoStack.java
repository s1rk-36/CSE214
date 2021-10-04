/**
 * Kristian Hajredinaj
 * 113367328
 * Recitation 4
 */

public class CargoStack {

    private int counter = 0;
    private int top;
    private Cargo[] cargos;

    /**
     * no arg constructor
     */
    public CargoStack(){
        top = -1;
        cargos = new Cargo[100];
    }

    /**
     *
     * @param cargo
     * pushes a cargo object into the stack
     */
    public void push(Cargo cargo) {
        try {
            if (top != -1 && (cargos[top].getStrength().getValue() < cargo.getStrength().getValue())) {
                throw new CargoStrengthException();
            } else {
                top++;
                cargos[top] = cargo;
                counter++;
            }
        } catch (CargoStrengthException e) {
            System.out.println(e);
        }
    }

    /**
     *
     * @return
     * pops and return the cargo at top
     */
    public Cargo pop(){
        Cargo x = cargos[top];
        top--;
        counter--;
        return x;
    }

    /**
     *
     * @return
     * the cargo at top
     */
    public Cargo peek(){
        return cargos[top];
    }

    /**
     *
     * @return
     * size of the stack
     */
    public int size(){
        return counter;
    }

    /**
     *
     * @return
     * checks if stack is empty or not
     */
    public boolean isEmpty(){
        return (top < 0);
    }

    /**
     *
     * @param stack
     * prints the dock
     */
    public static void PrintStack(CargoStack stack){
        System.out.println();
        CargoStack s1 = (CargoStack) stack.clone();
        String dock = "Dock: |=====|";
        while(!(s1.isEmpty())) {
            System.out.println(" ".repeat(dock.length() - 4) + s1.peek().getStrength().getValue());
            s1.pop();
        }

        System.out.println(dock);
    }

    /**
     *
     * @return
     * clones a stack object
     */
    public Object clone(){
        CargoStack copy = new CargoStack();
        for (int i = 0; i < size(); i++){
            copy.cargos[i] = cargos[i];
        }
        copy.top = top;
        return copy;
    }
}
