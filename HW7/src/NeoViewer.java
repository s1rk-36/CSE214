//Kristian Hajredinaj     113367328     Recitation 4

import java.util.Locale;
import java.util.Scanner;

public class NeoViewer {
    /**
     * main method
     * @param args
     */
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        System.out.print("Welcome to NEO Viewer");

        String menu = "Option Menu:\n" +
                "\tA) Add a page to the database\n" +
                "\tS) Sort the database\n" +
                "\tP) Print the database as a table\n" +
                "\tQ) Quit\n" +
                "Select a menu option: ";
        String subMenu = "R) Sort by referenceID\n" +
                "D) Sort by diameter\n" +
                "A) Sort by approach date\n" +
                "M) Sort by miss distance\n" +
                "Select a menu option: ";

        NeoDatabase database = new NeoDatabase();

        System.out.print(menu);

        boolean neoViewerOver = false;

        while(!neoViewerOver){

            String str = input.nextLine();
            str = str.toLowerCase(Locale.ROOT);

            switch (str){

                case("a") -> {
                    System.out.print("Enter the page to load: ");

                    int page = input.nextInt();
                    database.adAll(database.buildQueryURL(page));
                    input.nextLine();
                    System.out.print("Page loaded successfully!\n" + menu);
                }

                case("s") -> {
                    System.out.print(subMenu);
                    String option = input.nextLine();
                    option = option.toLowerCase(Locale.ROOT);

                    switch (option){
                        case("r") -> {
                            ReferenceIDComparator comp = new ReferenceIDComparator();
                            database.sort(comp);
                            System.out.println("Table sorted on ID");
                        }
                        case("d") -> {
                            DiameterComparator comp = new DiameterComparator();
                            database.sort(comp);
                            System.out.println("Table sorted on diameter");
                        }
                        case("a") -> {
                            ApproachDateComparator comp = new ApproachDateComparator();
                            database.sort(comp);
                            System.out.println("Table sorted on approach date");
                        }
                        case("m") -> {
                            MissDistanceComparator comp = new MissDistanceComparator();
                            database.sort(comp);
                            System.out.println("Table sorted on miss distance");
                        }
                        default ->
                            System.out.print("Invalid option!\n");

                    }

                    System.out.print(menu);
                }

                case("p") -> {
                    database.printTable();
                    System.out.print(menu);
                }

                case("q") -> {
                    System.out.print("Program terminating normally...");
                    neoViewerOver = true;
                }

                default -> {
                    System.out.print("Invalid option");
                    System.out.print(menu);
                }

            }
        }

    }
}
