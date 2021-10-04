/**
 * Kristian Hajredinaj
 * 113367328
 * Recitation 4
 */

public class SlideList {

    private SlideListNode head;
    private SlideListNode tail;
    private SlideListNode cursor;
    private int counter = 0;

    /**
     * no arg constructor
     */
    public SlideList() {
        head = null;
        tail = null;
        cursor = null;
    }

    /**
     *
     * @return
     * returns the number of slides
     */
    public int size() {
        return counter;
    }

    /**
     *
     * @return
     * the total duration of all slides
     */
    public double duration() {
        SlideListNode nodePtr = head;
        double answer = 0;
        while (nodePtr != null) {
            answer += nodePtr.getData().getDuration();
            nodePtr = nodePtr.getNext();
        }
        return answer;
    }

    /**
     *
     * @return
     * returns total number of bullets
     * for all slides
     */
    public int numBullets() {
        SlideListNode nodePtr = head;
        int answer = 0;
        while (nodePtr != null) {
            answer += nodePtr.getData().getNumBullets();
            nodePtr = nodePtr.getNext();
        }
        return answer;
    }

    /**
     *
     * @return
     * returns the cursor as a Slide object
     */
    public Slide getCursorSlide(){
        return cursor.getData();
    }

    /**
     * sets the cursor as the head
     */
    public void resetCursorHead() {
        cursor = head;
    }

    /**
     *
     * @throws EndOfListException
     * if the list is empty or cursor is tail
     */
    public void cursorForward() throws EndOfListException {
        if (cursor == null) throw new EndOfListException();

        cursor = cursor.getNext();
    }

    /**
     *
     * @throws EndOfListException
     * if the list is empty or cursor is head
     */
    public void cursorBackward() throws EndOfListException {
        if (cursor == head) throw new EndOfListException();

        cursor = cursor.getPrev();
    }

    /**
     *
     * @param newSlide
     * insert the newSlide before the cursor
     */
    public void insertBeforeCursor(Slide newSlide) {
        if (newSlide == null) throw new IllegalArgumentException();

        SlideListNode newNode = new SlideListNode(newSlide);

        if (cursor == null) {
            head = newNode;
            tail = newNode;
        } else if(cursor.getPrev() == null) {
            newNode.setNext(cursor);
            cursor.setPrev(newNode);
        } else {
            newNode.setNext(cursor);
            newNode.setPrev(cursor.getPrev());
            cursor.getPrev().setNext(newNode);
            cursor.setPrev(newNode);
        }
        cursor = newNode;
        counter++;
    }

    /**
     *
     * @param newSlide
     * inserts a new slide after as the tail
     */
    public void appendToTail(Slide newSlide) {
        if (newSlide == null) throw new IllegalArgumentException();

        SlideListNode newNode = new SlideListNode(newSlide);
        if (head == null) {
            head = newNode;
            cursor = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
        }
        tail = newNode;
        counter++;
    }

    /**
     *
     * @return
     * the slide being removed
     * @throws EndOfListException
     * if the list is empty
     */
    public Slide removeCursor() throws EndOfListException {
        if (cursor == null) throw new EndOfListException();

        Slide slide = new Slide();

        if (cursor.getPrev() == null) {
            cursor.getNext().setPrev(null);
            cursor = cursor.getNext();
        }
        else if(cursor.getNext() == null) {
            cursor = cursor.getPrev();
        } else {
            cursor.getNext().setPrev(cursor.getPrev());
            cursor.getPrev().setNext(cursor.getNext());
            cursor = cursor.getPrev();
        }
        counter--;
        return slide;
    }

    /**
     * prints a summary of the slideshow
     */
    public void print() {
        int i = 0;
        System.out.println("Slideshow Summary:");
        System.out.println("=".repeat(45));
        System.out.printf("%-10s%-15s%-13s%5s", "Slide", "Title", "Duration", "Bullets");
        System.out.println();
        System.out.println("-".repeat(45));

        SlideListNode current = head;
        while (current != null) {
            if (current == cursor)
                System.out.print("-> ");
            System.out.printf("%-10d%-15s%-13f%5d", i + 1, current.getData().getTitle(),
                    current.getData().getDuration(), current.getData().getNumBullets());
            System.out.println();
            current = current.getNext();
            i++;
        }
        System.out.println("=".repeat(45));
    }
}
