/**
 * Kristian Hajredinaj 113367328 R04
 */

public class StoryTreeNode {

    private static final String WIN_MESSAGE = "YOU WIN";
    private static final String LOSE_MESSAGE = "YOU LOSE";
    private String position;
    private String option;
    private String message;
    private StoryTreeNode leftChild;
    private StoryTreeNode middleChild;
    private StoryTreeNode rightChild;

    /**
     * no arg constructor
     */
    public StoryTreeNode(){
        leftChild = null;
        middleChild = null;
        rightChild = null;
    }

    /**
     *
     * @return
     * position of the node
     */
    public String getPosition(){
        return position;
    }

    /**
     *
     * @param position
     * the position the node will be changed into
     */
    public void setPosition(String position){
        this.position = position;
    }

    /**
     *
     * @return
     * the option of the node
     */
    public String getOption(){
        return option;
    }

    /**
     *
     * @param option
     * the option the node will be changed into
     */
    public void setOption(String option){
        this.option = option;
    }

    /**
     *
     * @return
     * the message of the node
     */
    public String getMessage(){
        return message;
    }

    /**
     *
     * @param message
     * the message it will be set to
     */
    public void setMessage(String message){
        this.message = message;
    }

    /**
     *
     * @return
     * the left child of the node
     */
    public StoryTreeNode getLeftChild(){
        return leftChild;
    }

    /**
     *
     * @param leftChild
     * the node the left child will be set to
     */
    public void setLeftChild(StoryTreeNode leftChild){
        this.leftChild = leftChild;
    }

    /**
     *
     * @return
     * right child of node
     */
    public StoryTreeNode getRightChild(){
        return rightChild;
    }
    /**
     *
     * @param rightChild
     * the node the right child will be set to
     */
    public void setRightChild(StoryTreeNode rightChild){
        this.rightChild = rightChild;
    }

    /**
     *
     * @return
     * middle child of node
     */
    public StoryTreeNode getMiddleChild(){
        return middleChild;
    }
    /**
     *
     * @param middleChild
     * the node the middle child will be set to
     */
    public void setMiddleChild(StoryTreeNode middleChild){
        this.middleChild = middleChild;
    }

    /**
     *
     * @return
     * whether or not a node is a leaf
     */
    public boolean isLeaf(){
        return leftChild == null && rightChild == null && middleChild == null;
    }

    /**
     *
     * @return
     * checks if a node is a winning node
     */
    public boolean isWinningNode(){
        return isLeaf() && message.contains(WIN_MESSAGE);
    }

    /**
     *
     * @return
     * checks if a node is a losing node
     */
    public boolean isLosingNode(){
        return isLeaf() && message.contains(LOSE_MESSAGE);
    }

}
