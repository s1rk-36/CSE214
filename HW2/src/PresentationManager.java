/**
 * Kristian Hajredinaj
 * 113367328
 * Recitation 4
 */

import java.util.Locale;
import java.util.Scanner;

/**
 * main method running the program
 * in a switch case
 */

public class PresentationManager {

    public static void main(String[] args) throws EndOfListException {

        Scanner input = new Scanner(System.in);
        System.out.print("Welcome to TeamManager\n");
        String menu = "F) Mover cursor forward\n" +
                        "B) Move cursor backward\n" +
                        "D) Display cursor slide\n" +
                        "E) Edit cursor slide\n" +
                        "P) Print presentation summary\n" +
                        "A) Append new slide to tail\n" +
                        "I) Insert new slide before cursor\n" +
                        "R) Remove slide at cursor\n" +
                        "H) Reset cursor to head\n" +
                        "Q) Quit\n" +
                        "Select a menu option: ";

        System.out.print(menu);

        boolean presentationOver = false;
        SlideList s = new SlideList();



        while(!presentationOver){

            String str = input.nextLine();
            str = str.toLowerCase(Locale.ROOT);
            Slide newSlide = new Slide();

            switch (str){
                case "f":
                    s.cursorForward();
                    System.out.println("The cursor has moved forward to slide \"" +
                            s.getCursorSlide().getTitle() + "\"");
                    System.out.print(menu);
                    break;

                case "b":
                    s.cursorBackward();
                    System.out.println("The cursor moved backward to slide \"" +
                            s.getCursorSlide().getTitle() + "\"");
                    System.out.print(menu);
                    break;

                case "d":
                    s.getCursorSlide().print();
                    System.out.println();
                    System.out.print(menu);
                    break;

                case "e":
                    System.out.print("Edit title, duration, or bullets? (t/d/b): ");
                    String edit = input.nextLine();
                    int index;
                    if(edit.equals("t")){
                        s.getCursorSlide().setTitle(edit);
                    } else if(edit.equals("d")){
                        double duration = input.nextDouble();
                        s.getCursorSlide().setDuration(duration);
                    } else if(edit.equals("b")){
                        System.out.print("Bullet index: ");
                        index = input.nextInt();
                        input.nextLine();
                        System.out.print("Delete or edit? (d/e): ");
                        String check = input.nextLine();
                        if (check.equals("d")){
                            s.getCursorSlide().removeBullet(index);
                            System.out.println("Bullet " + index + " has been deleted");
                        } else if (check.equals("e")) {
                            System.out.print("Bullet " + index + ": ");
                            String bulletEdit = input.nextLine();
                            s.getCursorSlide().setBullet(bulletEdit, index);
                        }
                    } else{
                        System.out.println("Invalid input");
                        System.out.print(menu);
                    }
                    System.out.print(menu);
                    break;

                case "p":
                    s.print();
                    System.out.println("Total: " + s.size() + " slide(s), " + s.duration() +
                            " minute(s), " + s.numBullets() + " bullet(s)");
                    System.out.print(menu);
                    break;

                case "a":

                    System.out.print("Enter the slide title: ");
                    str = input.nextLine();
                    newSlide.setTitle(str);

                    System.out.print("Enter the slide duration: ");
                    double duration = input.nextDouble();
                    newSlide.setDuration(duration);
                    input.nextLine();

                    int i = 1;
                    System.out.print("Bullet 1: ");
                    String newStr = input.nextLine();
                    newSlide.setBullet(newStr, i);

                    System.out.print("Add another bullet? (y/n): ");
                    str = input.nextLine();
                    while(str.equals("y")){
                        i++;
                        String bullet;
                        System.out.print("Bullet " + i + ": ");
                        bullet = input.nextLine();
                        newSlide.setBullet(bullet, i);

                        if (i == 5) {
                            System.out.println("No more bullets to add");
                            break;
                        }

                        System.out.print("Add another bullet? (y/n): ");
                        str = input.nextLine();
                    }
                    s.appendToTail(newSlide);

                    System.out.println("Slide \"" + newSlide.getTitle() +
                            "\" added to presentation");
                    System.out.print(menu);
                    break;

                case "i":

                    System.out.print("Enter the slide title: ");
                    str = input.nextLine();
                    newSlide.setTitle(str);

                    System.out.print("Enter the slide duration: ");
                    duration = input.nextDouble();
                    newSlide.setDuration(duration);
                    input.nextLine();

                    int ii = 1;
                    System.out.print("Bullet 1: ");
                    str = input.nextLine();
                    newSlide.setBullet(str, ii);
                    System.out.print("Add another bullet? (y/n): ");
                    str = input.nextLine();

                    while(str.equals("y")){
                        ii++;
                        String bullet;
                        System.out.print("Bullet " + ii + ": ");
                        bullet = input.nextLine();
                        newSlide.setBullet(bullet, ii);

                        if (ii == 5) {
                            System.out.println("No more bullets to add");
                            break;
                        }
                        System.out.print("Add another bullet? (y/n): ");
                        str = input.nextLine();
                    }
                    s.insertBeforeCursor(newSlide);
                    System.out.print(menu);
                    break;

                case "r":
                    System.out.println("Slide \"" + s.removeCursor().getTitle() + "\" has been removed");
                    System.out.print(menu);
                    break;

                case "h":
                    s.resetCursorHead();
                    System.out.println("The cursor has been moved to head");
                    System.out.print(menu);
                    break;

                case "q":
                    presentationOver = true;
                    break;

                default:
                    System.out.println("Invalid input");
                    System.out.print(menu);
                    break;
            }
        }
        System.out.print("The presentation is over...");
    }
}
