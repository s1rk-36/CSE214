/**
 * Kristian Hajredinaj 113367328 R04
 */

import java.io.*;
import java.util.*;


public class StorageManager {
    /**
     * main method
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Scanner input = new Scanner(System.in);
        System.out.println("Hello, and welcome to Rocky Stream Storage Manager");

        String menu = "P - Print all storage boxes\n" +
                "A - Insert into storage box\n" +
                "R - Remove contents from a storage box\n" +
                "C - Select all boxes owned by a particular client\n" +
                "F - Find a box by ID and display its owner and contents\n" +
                "Q - Quit and save workspace\n" +
                "X - Quit and delete workspace\n" +
                "Please select an option: ";
        System.out.print(menu);

        FileInputStream file = new FileInputStream("storage.obj");
        StorageTable storageTable = new StorageTable();
        try {
            ObjectInputStream inStream = new ObjectInputStream(file);
            storageTable = (StorageTable) inStream.readObject();
            inStream.close();
        } catch (EOFException e){

        }


        boolean gameOver = false;

        while(!gameOver){
            String str = input.nextLine();
            str = str.toLowerCase(Locale.ROOT);

            switch(str){

                case ("p") -> {
                    System.out.println(storageTable);
                    System.out.print(menu);
                }

                case ("a") -> {
                    Storage storage = new Storage();

                    System.out.print("Please enter id: ");
                    int id = input.nextInt();

                    input.nextLine();

                    System.out.print("Please enter client: ");
                    String client = input.nextLine();

                    System.out.print("Please enter Contents: ");
                    String contents = input.nextLine();

                    storage.setId(id);
                    storage.setClient(client);
                    storage.setContents(contents);
                    storageTable.put(id, storage);
                    storageTable.putStorage(id, storage);
                    System.out.print("Storage " + id + " set !\n" + menu);
                }

                case("r") -> {
                    System.out.print("Please enter ID: ");
                    int id = input.nextInt();
                    if(storageTable.containsKey(id)){
                        storageTable.remove(id);
                        storageTable.removeStorage(id);
                        System.out.print("Box " + id + " is now removed\n" + menu);
                    } else
                        System.out.print("This box does not exist\n" + menu);
                }

                case("c") -> {
                    System.out.print("Please enter the name of the client: ");
                    String client = input.nextLine();

                    StringBuilder info = new StringBuilder(String.format("%-20s%-30s%-30s", "Box#", "Contents", "Owner"));
                    info.append("\n").append("-".repeat(info.length()));

                    ArrayList<Integer> sortedKeys = new ArrayList<Integer>(storageTable.keySet());
                    Collections.sort(sortedKeys);

                    for(Integer x : sortedKeys){
                        if (storageTable.getStorage(x).getClient().equals(client))
                        info.append("\n").append(String.format("%-20d%-30s%-30s", storageTable.getStorage(x).getId(),
                                storageTable.getStorage(x).getContents(), storageTable.getStorage(x).getClient()));
                    }
                    System.out.println(info);
                    System.out.print(menu);
                }

                case ("f") -> {
                    System.out.print("Please enter ID: ");
                    int id  = input.nextInt();
                    if (!storageTable.containsKey(id))
                        System.out.print("That box does not exist\n" + menu);
                    else {
                        System.out.println("Box " + id);
                        System.out.println("Contents: " + storageTable.getStorage(id).getContents());
                        System.out.println("Owner: " + storageTable.getStorage(id).getClient());
                        System.out.print(menu);
                    }
                }

                case("q") -> {
                    FileOutputStream file1 = new FileOutputStream("storage.obj");
                    ObjectOutputStream outStream = new ObjectOutputStream(file1);
                    outStream.writeObject(storageTable);
                    outStream.close();
                    System.out.println("Storage Manager is quitting, current storage is saved for next session.");
                    gameOver = true;
                }

                case("x") -> {
                    FileWriter fwOb = new FileWriter("storage.obj", false);
                    PrintWriter pwOb = new PrintWriter(fwOb, false);
                    pwOb.flush();
                    pwOb.close();
                    fwOb.close();
                    System.out.println("Storage Manager is quitting, all data is being erased.");
                    gameOver = true;
                }
            }


        }
    }

}
