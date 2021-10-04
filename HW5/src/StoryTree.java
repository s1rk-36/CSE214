/**
 * Kristian Hajredinaj 113367328 R04
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class StoryTree {

    private StoryTreeNode root;
    private StoryTreeNode cursor;
    private GameState state;

    /**
     * no arg constructor
     */
    public StoryTree(){
        root = new StoryTreeNode();
        root.setPosition("root");
        root.setOption("root");
        root.setMessage("Hello, welcome to Zork!");
        cursor = root;
    }

    /**
     *
     * @param filename
     * the name of the file
     * @return
     * a tree in a preorder form
     */
    public static StoryTree readTree(String filename){
        if(filename == null)
            throw new IllegalArgumentException("An error occurred");

        StoryTree storyTree = new StoryTree();

        try{
            File myFile = new File(filename);
            Scanner fileIn = new Scanner(myFile);
            int count = 0;

            while(fileIn.hasNext()){
                count++;
                String info = fileIn.nextLine();

                String[] token = info.split("\\|");

                if (token.length != 3) throw new DataFormatException();

                String position = token[0];
                String option = token[1];
                String message = token[2];

                if(position.endsWith(" "))
                    position = position.substring(0, position.length() - 1) + "";

                if(option.startsWith(" "))
                    option = option.substring(1);
                else if (option.endsWith(" "))
                   option = option.substring(0, option.length() - 1) + "";

                if(message.startsWith(" "))
                    message = message.substring(1);
                else if (message.endsWith(" "))
                    message = message.substring(0, message.length() - 1) + "";

                StoryTreeNode currentNode = storyTree.root;
                StoryTreeNode newNode = new StoryTreeNode();

                newNode.setPosition(position);
                newNode.setOption(option);
                newNode.setMessage(message);

                String[] place = position.split("-");

                for (int i = 0; i < place.length; i++){

                    if (place[i].equals("1")){

                        if (i == place.length - 1){
                            currentNode.setLeftChild(newNode);
                            if (count == 1) {
                                storyTree.cursor = newNode;
                            }
                        } else
                            currentNode = currentNode.getLeftChild();
                    }
                    if (place[i].equals("2")){

                        if (i == place.length - 1)
                           currentNode.setMiddleChild(newNode);
                         else
                            currentNode = currentNode.getMiddleChild();
                    }
                    if (place[i].equals("3")){

                        if (i == place.length - 1)
                            currentNode.setRightChild(newNode);
                         else
                            currentNode = currentNode.getRightChild();
                    }
                }

            }

            fileIn.close();
        } catch (FileNotFoundException | DataFormatException e){
            System.out.println("An error occurred");
        }

        return storyTree;
    }

    /**
     *
     * @param filename
     * the name of the file to write to
     * @param tree
     * the tree to write to
     */
    public static void saveTree(String filename, StoryTree tree){
        if (filename == null || tree == null)
            throw new IllegalArgumentException("error");

        try{
            File myFile = new File(filename);
            PrintWriter fileOut = new PrintWriter(myFile);
            fileOut.write(tree.getCursorPosition() + " \\| " +  tree.getCursorOption() + " \\| "
                    + tree.getCursorMessage());
            saveTree(filename, tree);

            fileOut.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred");
        }
    }

    /**
     *
     * @return
     * state of the game
     */
    public GameState getGameState(){
        return state;
    }

    /**
     *
     * @return
     * position of cursor
     */
    public String getCursorPosition(){
        return cursor.getPosition();
    }

    /**
     *
     * @return
     * message of the cursor
     */
    public String getCursorMessage(){
        return cursor.getMessage();
    }

    /**
     *
     * @return
     * option of the cursor
     */
    public String getCursorOption(){
        return cursor.getOption();
    }

    /**
     *
     * @return
     * options available
     */
    public String[][] getOptions(){

        String[][] pairs = new String[3][2];

        if(cursor.getLeftChild() == null){
            pairs[0] = new String[]{"", ""};
        }
        else{
            pairs[0] = new String[]{cursor.getLeftChild().getPosition(), cursor.getLeftChild().getOption()};
        }

        if(cursor.getMiddleChild() == null){
            pairs[1] = new String[]{"", ""};
        }
        else{
            pairs[1] = new String[]{cursor.getMiddleChild().getPosition(), cursor.getMiddleChild().getOption()};
        }

        if(cursor.getRightChild() == null){
            pairs[2] = new String[]{"", ""};
        }
        else{
            pairs[2] = new String[]{cursor.getRightChild().getPosition(), cursor.getRightChild().getOption()};
        }
        return pairs;
    }

    /**
     *
     * @return
     * the cursor
     */
    public StoryTreeNode getCursor(){
        return cursor;
    }

    /**
     *
     * @param message
     * the message to be set to
     */
    public void setCursorMessage(String message){
        cursor.setMessage(message);
    }

    /**
     *
     * @param option
     * the option to be set to
     */
    public void setCursorOption(String option){
        cursor.setOption(option);
    }

    /**
     * moves cursor back to first node
     */
    public void resetCursor(){
        cursor = root.getLeftChild();
    }

    /**
     *
     * @param position
     * the position of the child
     * @throws NodeNotPresentException
     * if the node is not there
     */
    public void selectChild(String position) throws NodeNotPresentException {
        if (position == null)
            throw new IllegalArgumentException("An error occurred");

        if (position.equals("1")){
            if (cursor.getLeftChild() == null)
                throw new NodeNotPresentException();
            cursor = cursor.getLeftChild();
        } else if (position.equals("2")){
            if (cursor.getMiddleChild() == null)
                throw new NodeNotPresentException();
            cursor = cursor.getMiddleChild();
        } else if(position.equals("3")){
            if (cursor.getRightChild() == null)
                throw new NodeNotPresentException();
            cursor = cursor.getRightChild();
        }
    }

    /**
     *
     * @param option
     * the option of the child
     * @param message
     * the message of the child
     * @throws TreeFullException
     * if the tree is full
     */
    public void addChild(String option, String message) throws TreeFullException {
        if (option == null || message == null)
            throw new IllegalArgumentException("Error");
        if (cursor.getLeftChild() != null && cursor.getMiddleChild() != null &&
        cursor.getRightChild() != null)
            throw new TreeFullException();

        StoryTreeNode temp = cursor;
        temp.setOption(option);
        temp.setMessage(message);

        String end = "0";
        if(cursor.getLeftChild() == null){
            cursor.setLeftChild(temp);
            end = "1";
        } else if (cursor.getMiddleChild() == null){
            cursor.setMiddleChild(temp);
            end = "2";
        } else if(cursor.getRightChild() == null){
            cursor.setRightChild(temp);
            end = "3";
        }

        String position = cursor.getPosition() + end;
        temp.setPosition(position);

    }

    /**
     *
     * @param position
     * position of child to be removed
     * @return
     * the child that was removed
     * @throws NodeNotPresentException
     * if the node does not exist
     */
    public StoryTreeNode removeChild(String position) throws NodeNotPresentException {
        if (cursor.getLeftChild() == null && cursor.getMiddleChild() == null &&
                cursor.getRightChild() == null)
            throw new NodeNotPresentException();

        StoryTreeNode temp = new StoryTreeNode();

        switch (position){

            case("1") -> {
                temp = cursor.getLeftChild();
                cursor.getMiddleChild().setPosition(cursor.getLeftChild().getPosition());
                cursor.setLeftChild(cursor.getMiddleChild());
                cursor.getRightChild().setPosition(cursor.getMiddleChild().getPosition());
                cursor.setMiddleChild(cursor.getRightChild());
                cursor.setRightChild(null);
            }

            case("2") -> {
                temp = cursor.getMiddleChild();

                cursor.getRightChild().setPosition(cursor.getMiddleChild().getPosition());
                cursor.setMiddleChild(cursor.getRightChild());
                cursor.setRightChild(null);
            }

            case("3") -> {
                temp = cursor.getRightChild();
                cursor.setRightChild(null);
            }
        }
        return temp;
    }

}
