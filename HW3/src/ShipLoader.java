/**
 * Kristian Hajredinaj
 * 113367328
 * Recitation 4
 */


/**
 * main method that runs on a switch case
 */

import java.util.Locale;
import java.util.Scanner;

public class ShipLoader {

    public static void main(String[] args)
            throws EmptyStackException {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to ShipLoader!");
        System.out.println("Cargo Ship Parameters");
        System.out.println("-".repeat(45));
        System.out.print("Number of stacks: ");
        int numStacks = input.nextInt();
        System.out.print("Maximum height of stacks: ");
        int height = input.nextInt();
        System.out.print("Maximum total cargo weight: ");
        double weight = input.nextDouble();

        CargoShip ship = new CargoShip(numStacks, height, weight);
        CargoStack stack = new CargoStack();

        System.out.println("Cargo ship created.\n" + "Pulling ship in to dock...\n" +
                "Cargo ship ready to be loaded");


        String menu = "Please select an option:\n" +
                       "C) Create new cargo\n" +
                       "L) Load cargo from dock\n" +
                       "U) Unload cargo from ship\n" +
                       "M) Move cargo from ship\n" +
                       "K) Clear dock\n" +
                       "P) Print ship stacks\n" +
                       "S) Search for cargo\n" +
                       "Q) Quit\n" +
                       "Select a menu option: ";
        System.out.print(menu);

        boolean shipLoaderOver = false;

        while(!shipLoaderOver){

            String str = input.nextLine();
            str = str.toLowerCase(Locale.ROOT);

            switch(str) {

                case "c":

                    System.out.print("Enter the name of the cargo: ");
                    String name = input.nextLine();
                    System.out.print("Enter the weight of the cargo: ");
                    double cargoWeight = input.nextDouble();
                    System.out.print("Enter the container strength (F/M/S): ");
                    input.nextLine();
                    String strength = input.nextLine();

                    CargoStrength cargoStrength = switch (strength) {
                        case "F" -> CargoStrength.FRAGILE;
                        case "M" -> CargoStrength.MODERATE;
                        case "S" -> CargoStrength.STURDY;
                        default -> null;
                    };
                    Cargo cargo = new Cargo(name, cargoWeight, cargoStrength);

                    stack.push(cargo);

                    System.out.println("Cargo '" + cargo.getName() + "' pushed onto the dock");
                    CargoStack.PrintStack(stack);
                    ship.PrintShip(ship);
                    System.out.print(menu);
                    break;

                case "l":

                    System.out.print("Select the load destination stack index: ");
                    int index = input.nextInt();
                    ship.pushCargo(stack.peek(), index);
                    System.out.println("Cargo '" + stack.pop().getName() +
                            "' moved from dock to stack " + index);
                    CargoStack.PrintStack(stack);
                    ship.PrintShip(ship);
                    System.out.print(menu);
                    break;

                case "u":

                    System.out.print("Select the unload source stack index: ");
                    index = input.nextInt();
                    stack.push(ship.popCargo(index));
                    System.out.println("Cargo moved from stack " + index + " to dock");
                    System.out.print(menu);
                    break;

                case "m":

                    System.out.print("Source stack index: ");
                    int initIndex = input.nextInt();
                    System.out.print("Destination stack index: ");
                    int desIndex = input.nextInt();
                    ship.pushCargo(ship.popCargo(initIndex), desIndex);
                    System.out.println("Cargo moved from stack " + initIndex + " to stack " +desIndex);
                    System.out.print(menu);
                    break;

                case "k":

                    int size = stack.size();
                    for (int i = 0; i < size; i++){
                        stack.pop();
                    }
                    System.out.println("Dock cleared");
                    CargoStack.PrintStack(stack);
                    ship.PrintShip(ship);
                    System.out.print(menu);
                    break;

                case "s":

                    System.out.print("Enter the name of the cargo: ");
                    String cargoName = input.nextLine();
                    System.out.println("Cargo '" + cargoName + "' found at the following locations: ");
                    ship.finAndPrint(cargoName);
                    System.out.println();
                    System.out.print(menu);
                    break;

                case "q":
                    shipLoaderOver = true;
                    break;
//
//                default:
//                    System.out.println("You entered an invalid option");
//                    System.out.print(menu);
//                    break;
            }
        }
        System.out.println("Ship Loader over.");
    }

}
