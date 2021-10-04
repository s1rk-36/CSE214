/**
 * Kristian Hajredinaj ID: 113367328 Recitation 4
 */


public class Vehicle {

    private static int serialCounter = 0;
    private int serialId;
    private int timeArrived;

    /**\
     *
     * @param initTimeArrived
     * the time a vehicle arrives
     * @throws IllegalArgumentException
     * if the time is not in valid range
     */
    public Vehicle(int initTimeArrived) throws IllegalArgumentException{
        if(initTimeArrived <= 0)
            throw new IllegalArgumentException();

        timeArrived = initTimeArrived;
        serialId = ++serialCounter;
    }

    /**
     *
     * @return
     * the unique id of a vehicle
     */
    public int getSerialId(){
        return serialId;
    }

    /**
     *
     * @return
     * the time a vehicle arrived
     */
    public int getTimeArrived(){
        return timeArrived;
    }

}
