/**
 * Kristian Hajredinaj ID: 113367328 Recitation 4
 */


public class TwoWayRoad{

    public final int FORWARD_WAY = 0;
    public final int BACKWARD_WAY = 1;
    public static final int NUM_WAYS = 2;

    public final int LEFT_LANE = 0;
    public final int MIDDLE_LANE = 1;
    public final int RIGHT_LANE = 2;
    public static final int NUM_LANES = 3;

    private String name;
    private int greenTime;
    private int leftSignalGreenTime;
    private VehicleQueue[][] lanes;
    private LightValue lightValue;

    /**
     *
     * @param initName
     * the name of the road
     * @param initGreenTime
     * the max green time of the road
     */
    public TwoWayRoad(String initName, int initGreenTime){
        if (initGreenTime <= 0 || initName == null)
            throw new IllegalArgumentException();

        lanes = new VehicleQueue[NUM_WAYS][NUM_LANES];
        name = initName;
        greenTime = initGreenTime;
        leftSignalGreenTime = (int) Math.floor(1/NUM_LANES * initGreenTime);
    }

    /**
     *
     * @return
     * green time
     */
    public int getGreenTime(){
        return greenTime;
    }

    /**
     *
     * @return
     * the light value
     */
    public LightValue getLightValue(){
        return lightValue;
    }

    /**
     *
     * @return
     * the name of the road
     */
    public String getName(){return name;}

    /**
     *
     * @param timerVal
     * the max green time
     * @return
     * the vehicles that are dequeued
     * @throws Exception
     * if timerVal is not in valid range
     */
    public Vehicle[] proceed(int timerVal) throws Exception {
        if(timerVal <= 0)
            throw new IllegalArgumentException();

        Vehicle[] temp = new Vehicle[6];

        int index = 0;
        if(timerVal > leftSignalGreenTime){
            lightValue = LightValue.GREEN;
            for (int i = 0; i < NUM_WAYS; i++){
                for (int j = 1; i < NUM_LANES; j++){
                    if (lanes[i][j].isEmpty())
                        continue;

                    temp[index] = lanes[i][j].dequeue();
                    index++;
                }
            }
        }
        else if (timerVal == 0)
            lightValue = LightValue.RED;
        else if(timerVal <= leftSignalGreenTime){
            lightValue = LightValue.LEFT_SIGNAL;
            for (int i = 0; i < NUM_WAYS; i++){
                if(lanes[i][0].isEmpty())
                    continue;

                temp[index] = lanes[i][0].dequeue();
                index++;
            }
        }

        return temp;
    }

    /**
     *
     * @param wayIndex
     * which way the vehicle is going
     * @param laneIndex
     * the lane of the vehicle
     * @param vehicle
     * vehicle object
     */
    public void enqueueVehicle(int wayIndex, int laneIndex, Vehicle vehicle){
        if(wayIndex > 1 || wayIndex < 0 || laneIndex < 0 || laneIndex > 2|| vehicle == null)
            throw new IllegalArgumentException();

        lanes[wayIndex][laneIndex].enqueue(vehicle);
    }

    /**
     *
     * @param wayIndex
     * which way the vehicle is going
     * @param laneIndex
     * which lane the vehicle is
     * @return
     * whether the lane is empty or not
     */
    public boolean isLaneEmpty(int wayIndex, int laneIndex){
        if(wayIndex > 1 || wayIndex < 0 || laneIndex < 0 || laneIndex > 2)
            throw new IllegalArgumentException();

        return lanes[wayIndex][laneIndex].isEmpty();
    }

}
