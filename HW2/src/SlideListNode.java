/**
 * Kristian Hajredinaj
 * 113367328
 * Recitation 4
 */

public class SlideListNode {

    private Slide data;
    private SlideListNode next;
    private SlideListNode prev;

    /**
     *
     * @param initData
     * constructor for the node
     */
    public SlideListNode(Slide initData){
        if(initData == null)
            throw new IllegalArgumentException();
        data = initData;
        next = null;
        prev = null;
    }

    /**
     *
     * @return
     * a slide object
     */
    public Slide getData(){
        return data;
    }

    /**
     *
     * @return
     * gets the next node
     */
    public SlideListNode getNext(){
        return next;
    }

    /**
     *
     * @return
     * returns the previous node
     */
    public SlideListNode getPrev(){
        return prev;
    }

    /**
     *
     * @param newData
     * the slide object to be set to
     */
    public void setData(Slide newData){
        if(newData == null)
            throw new IllegalArgumentException();
        data = newData;
    }

    /**
     *
     * @param newNext
     * what the next node is set to
     */
    public void setNext(SlideListNode newNext){
        next = newNext;
    }

    /**
     *
     * @param newPrev
     * what the previous node is set to
     */
    public void setPrev(SlideListNode newPrev){
        prev = newPrev;
    }

}
