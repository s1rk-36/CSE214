/**
 * Kristian Hajredinaj
 * 113367328
 * Recitation 4
 */

public class Slide {

    private static final int MAX_BULLETS = 5;
    private String title;
    private String[] bullets;
    private double duration;
    private int counter = 0;

    /**
     * a no arg constructor
     */
    public Slide(){
        title = "";
        bullets = new String[MAX_BULLETS];
        duration = 0.0;
    }

    /**
     *
     * @return
     * title of slide
     */
    public String getTitle(){
        return title;
    }

    /**
     *
     * @param i
     * the position of bullet in the slide
     * @return
     * The bullet at position
     */
    public String getBullet(int i){
        try {
            if(!(1<=i || i<=MAX_BULLETS))
                throw new IllegalArgumentException();

        } catch (IllegalArgumentException e){
            System.out.print("The position is invalid.");
        }
        return bullets[i];
    }

    /**
     *
     * @return
     * total number of bullets in the slide
     */
    public int getNumBullets(){
        return counter;
    }

    /**
     *
     * @return
     * the duration of the slide
     */
    public double getDuration(){
        return duration;
    }

    /**
     * removes a bullet
     * @param position
     * position to be removed
     * @throws IllegalArgumentException
     * if the position is out of bounds
     */
    public void removeBullet(int position) throws IllegalArgumentException {
        try {
            if (position + 1 < 1 || position >= counter)
                throw new IllegalArgumentException();

            for(int i = (position - 1); i < counter; i++) {
                bullets[i] = bullets[i + 1];
            }
            counter--;
        } catch(IllegalArgumentException e){
            System.out.print("The position entered is not in valid range");
        }
    }

    /**
     *
     * @param newTitle
     * sets a new title
     */
    public void setTitle(String newTitle){
        try {
            if (newTitle.equals(null))
                throw new IllegalArgumentException();
            title = newTitle;
        } catch(IllegalArgumentException e){
            System.out.print("The title is null.");
        }
    }

    /**
     *
     * @param newDuration
     * the duration to be set to
     */
    public void setDuration(double newDuration){
        try{
            if (newDuration <= 0)
                throw new IllegalArgumentException();
            duration = newDuration;
        } catch (IllegalArgumentException e){
            System.out.print("The duration entered is invalid.");
        }
    }

    /**
     *
     * @param bullet
     * the bullet to be set to
     * @param i
     * the position of the bullet
     */
    public void setBullet(String bullet, int i){
        try {
            if(!(1<=i || i <= MAX_BULLETS))
                throw new IllegalArgumentException();

        } catch (IllegalArgumentException e){
            System.out.print("The position is invalid.");
        }
        if (bullets[i - 1] == null) {
            bullets[i - 1] = bullet;
            counter++;
        } else
            bullets[i - 1] = bullet;
    }

    /**
     * prints the bullets of a slide
     */
    public void print(){
        System.out.println("=".repeat(45));
        System.out.println("   " + title);
        System.out.println("=".repeat(45));
        for(int i = 0; i < counter; i++){
            if (bullets[i] == null)
                break;
            System.out.print((i+1) + ". " + bullets[i]);
            System.out.println();
        }
        System.out.print("=".repeat(45));
    }
}
