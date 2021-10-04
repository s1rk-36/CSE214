
/**
 *
 * @author //Kristian Hajredinaj ID; 113367328 Recitation 4
 *
 * Player Class
 */
public class Player implements Cloneable{

    private String name;
    private int numHits;
    private int numErrors;

    /**
     * @constructor
     * no arg constructor
     */
    public Player(){
        name = "";
        numHits = 0;
        numErrors = 0;
    }

    /**
     *
     * @return Player name
     */
    public String getName(){
        return name;
    }
    /**
     *
     * @return Player numHits
     */
    public int getNumHits(){
        return numHits;
    }
    /**
     *
     * @return Player numErrors
     */
    public int getNumErrors(){
        return numErrors;
    }

    /**
     *
     * @param name
     * Name to change
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     *
     * @param numHits
     * The number that it will be set to
     * @throws IllegalArgumentException
     */
    public void setNumHits(int numHits) throws IllegalArgumentException{
        this.numHits = numHits;
    }

    /**
     *
     * @param numErrors
     * the number of errors it will be set to
     * @throws IllegalArgumentException
     */
    public void setNumErrors(int numErrors) throws IllegalArgumentException{
        this.numErrors = numErrors;
    }

    /**
     *
     * @return
     * a clone of the Person class
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException{
        Player p = (Player)super.clone();
        p.name = this.name;
        p.numHits = this.numHits;
        p.numErrors = this.numErrors;
        return p;
    }

    /**
     *
     * @param obj
     *takes in an Object
     * @return
     * true if 2 Player objects
     * have the same traits
     */
    public boolean equals(Object obj){
        if(obj instanceof Player){
            Player p = (Player) obj;
            return (p.name.equals(name) && p.numHits == numHits && p.numErrors == numErrors);
        } else
            return false;
    }

    /**
     *
     * @return
     * A string with the Player info
     */
    public String toString(){
        return getName() + " - " + getNumHits() + ((getNumHits() == 1)? " hit " : " hits ")
                + getNumErrors() + ((getNumErrors() == 1) ? " error" : " errors\n");
    }

}
