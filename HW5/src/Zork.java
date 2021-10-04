/**
 * Kristian Hajredinaj 113367328 R04
 */

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/**
 * main method
 */
public class Zork {
    public static void main(String[] args) throws TreeFullException, NodeNotPresentException {

        Scanner input = new Scanner(System.in);
        System.out.println("Hello and Welcome to Zork!");
        System.out.print("Please enter a file name: ");
        String filename = input.nextLine();

        String menu = ("Loading game from file...\nFile loaded!\n" +
                "Would you like to edit (E), play (P) or quit (Q)?");
        System.out.print(menu);

        boolean gameOver = false;

        while(!gameOver){
            String str = input.nextLine();
            str = str.toLowerCase(Locale.ROOT);
            switch (str) {
                case ("e") -> {
                    System.out.println("Let's edit");
                    editTree(StoryTree.readTree(filename));
                    System.out.print(menu);
                }
                case ("p") -> {
                    playTree(StoryTree.readTree(filename));
                    System.out.print(menu);
                }
                case ("q") -> {
                    gameOver = true;
                }
            }
        }
        System.out.println("Game being saved to " + filename + "\nSave successful!\n" +
                "Program terminating normally");

    }

    /**
     *
     * @param tree
     * the tree to be edited
     * @throws NodeNotPresentException
     * if the node is not there
     * @throws TreeFullException
     * if the tree is full
     */
    public static void editTree(StoryTree tree) throws NodeNotPresentException, TreeFullException {
        Scanner input = new Scanner(System.in);
        String menu = "Zork Editor\n" +
                "V: View the cursor's position, option and message.\n" +
                "S: Select a child of this cursor (options are 1, 2, and 3).\n" +
                "O: Set the option of the cursor.\n" +
                "M: Set the message of the cursor.\n" +
                "A: add a child StoryNode to the cursor.\n" +
                "D: Delete one of the cursor's  children and all its descendants.\n" +
                "R: Move the cursor to the root of the tree.\n" +
                "Q: Quit editing and return to main menu\n" +
                "Please select an option: ";
        System.out.print(menu);


        boolean editOver = false;
        while(!editOver){
            String choose = input.nextLine();
            choose = choose.toLowerCase(Locale.ROOT);
            switch(choose){

                case("v") -> {
                    System.out.println("Position: " + tree.getCursorPosition());
                    System.out.println("Option: " + tree.getCursorOption());
                    System.out.println("Message: " + tree.getCursorMessage());
                    System.out.print(menu);
                }

                case("s") -> {
                    System.out.print("Please select a child: [1, 2, 3]: ");
                    String child = input.nextLine();
                    if (!child.equals("1") && !child.equals("2") && !child.equals("3")){
                        System.out.println("No child " + child + " for the current node.");
                        System.out.print(menu);
                    } else{
                        tree.selectChild(child);
                        System.out.print(menu);
                    }
                }

                case("o") -> {
                    System.out.print("Please enter a new option: ");
                    String newOption = input.nextLine();
                    tree.setCursorOption(newOption);
                    System.out.print("Option set\n" + menu);
                }

                case("m") -> {
                    System.out.print("Please enter a new Message: ");
                    String newMessage = input.nextLine();
                    tree.setCursorMessage(newMessage);
                    System.out.print("Message set\n" + menu);
                }

                case("a") -> {
                    System.out.print("Enter an option: ");
                    String option = input.nextLine();
                    System.out.print("Enter a message: " );
                    String message = input.nextLine();
                    tree.addChild(option, message);
                    System.out.print("Child added.\n" + menu);
                }

                case("d") -> {
                    System.out.print("please select a child: [1, 2] ");
                    String position = input.nextLine();
                    tree.removeChild(position);
                    System.out.print("Subtree deleted.\n" + menu);

                }

                case("r") -> {
                    tree.resetCursor();
                    System.out.print("Cursor moved to root.\n" + menu);
                }

                case("q") ->
                    editOver = true;

                default -> System.out.print("Invalid option." + menu);
            }
        }
    }

    /**
     *
     * @param tree
     * the tree to play
     * @throws NodeNotPresentException
     * if the node is not there
     */
    public static void playTree(StoryTree tree) throws NodeNotPresentException {
        Scanner input = new Scanner(System.in);
        System.out.println(tree.getCursorOption());
        System.out.println(tree.getCursorMessage());
        for (int i =  0; i < 3; i++){
            if (Arrays.equals(tree.getOptions()[i], new String[]{"", ""}))
                continue;
            else
                System.out.println(Arrays.toString(tree.getOptions()[i]));
        }
        System.out.print("Please make a choice: ");
        String choice = input.nextLine();
        switch (choice){

            case("1") -> {
                tree.selectChild("1");
                if (tree.getCursor().isWinningNode()){
                    System.out.println(tree.getCursorMessage());
                    System.out.println("Thank you for playing");
                    break;
                } else if (tree.getCursor().isLosingNode()){
                    System.out.println(tree.getCursorMessage());
                    System.out.println("You lost. Try again");
                    break;
                }
                playTree(tree);

            }
            case("2") -> {
                tree.selectChild("2");
                if (tree.getCursor().isWinningNode()){
                    System.out.println(tree.getCursorMessage());
                    System.out.println("Thank you for playing");
                    break;
                } else if (tree.getCursor().isLosingNode()){
                    System.out.println(tree.getCursorMessage());
                    System.out.println("You lost. Try again");
                    break;
                }
                playTree(tree);
            }case("3") -> {
                tree.selectChild("3");
                if (tree.getCursor().isWinningNode()){
                    System.out.println(tree.getCursorMessage());
                    System.out.println("Thank you for playing");
                    break;
                } else if (tree.getCursor().isLosingNode()){
                    System.out.println(tree.getCursorMessage());
                    System.out.println("You lost. Try again");
                    break;
                }
                playTree(tree);
            }
        }

    }
}
