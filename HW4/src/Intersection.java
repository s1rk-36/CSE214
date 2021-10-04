/**
 * Kristian Hajredinaj ID: 113367328 Recitation 4
 */


import java.util.Stack;

public class Intersection {

    private TwoWayRoad[] roads;
    private int lightIndex;
    private int countdownTimer;
    private int MAX_ROADS = 4;

    /**
     *
     * @param initRoads
     * array of roads
     */
    public Intersection(TwoWayRoad[] initRoads){
        if(initRoads == null || initRoads.length > MAX_ROADS)
            throw new IllegalArgumentException("error");
        for (int i = 0; i < initRoads.length; i++){
            if (initRoads[i] == null)
                throw new IllegalArgumentException("error");
        }
        roads = new TwoWayRoad[initRoads.length];
        for (int i = 0; i < initRoads.length; i++){
            roads[i] = initRoads[i];
        }

        lightIndex = 0;
    }

    /**
     *
     * @return
     * the vehicles that are dequeued
     * @throws Exception
     */
    public Vehicle[] timeStep() throws Exception {

        countdownTimer = roads[lightIndex].getGreenTime();
        Vehicle[] temp;
        temp = roads[lightIndex].proceed(countdownTimer);
        if (roads[lightIndex].getLightValue() == LightValue.RED)
            lightIndex++;

        return temp;
    }

    /**
     *
     * @param roadIndex
     * which road
     * @param wayIndex
     * the way the car is going
     * @param laneIndex
     * the lane is car is on
     * @param vehicle
     * vehicle object
     */
    public void enqueueVehicle(int roadIndex, int wayIndex, int laneIndex, Vehicle vehicle){
        if (vehicle == null || roadIndex < 0 || roadIndex > roads.length ||
                wayIndex < 0 || wayIndex > TwoWayRoad.NUM_WAYS || laneIndex < 0 ||
                laneIndex > TwoWayRoad.NUM_LANES)
            throw new IllegalArgumentException("error");

        roads[roadIndex].enqueueVehicle(wayIndex, laneIndex, vehicle);
    }

    /**
     * prints the cars at an intersection
     */
    public void display(){

        int index = 0;
        java.util.Stack<TwoWayRoad> cars = new Stack<>();
        for (int i = 0; i < roads.length; i++){
            cars.push(roads[i]);
        }

        System.out.println(roads[index].getName() + ":");
        System.out.printf("20%s,5%s,-20%s", "FORWARD", " ", "BACKWARD");

    }

    /**
     *
     * @return
     * the road index
     */
    public int getLightIndex() {
        return lightIndex;
    }

    /**
     *
     * @return
     * countdown timer
     */
    public int getCountdownTimer(){
        return countdownTimer;
    }

    /**
     *
     * @return
     * lightValue of the road at light index
     */
    public LightValue  getCurrentLightValue(){
        return roads[lightIndex].getLightValue();
    }

    /**
     *
     * @return
     * number of roads
     */
    public int getNumRoads(){
        return roads.length;
    }
}
