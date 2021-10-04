/**
 * Kristian Hajredinaj ID: 113367328 Recitation 4
 */


import java.util.Scanner;

public class IntersectionSimulator {

    public static void main(String[] args) throws Exception {

        System.out.println("Welcome to IntersectionSimulator 2021");

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the simulation time: ");
        int simulationTime = input.nextInt();
        System.out.print("Enter the arrival probability: ");
        double probability = input.nextDouble();
        System.out.print("Enter the number of Streets: ");
        int numRoads = input.nextInt();
        String[] roadNames = new String[numRoads];
        int[] maxGreenTimes = new int[numRoads];
        input.nextLine();
        for (int i = 0; i < numRoads; i++){
            System.out.print("Input Street " + (i + 1) + " name: ");
            roadNames[i] = input.nextLine();
            if (i != 0 && roadNames[i].equals(roadNames[i - 1])){
                System.out.println("Duplicate detected.");
                System.out.print("Input Street " + (i + 1) + " name: ");
                roadNames[i] = input.nextLine();
            }
        }
        for (int i = 0; i < numRoads; i++){
            System.out.print("Input max green time for " + roadNames[i] + ": ");
            maxGreenTimes[i] = input.nextInt();
        }

        System.out.println("Starting Simulation...\n" + "#".repeat(50));
        simulate(simulationTime, probability, roadNames, maxGreenTimes, numRoads);

    }

    /**
     *
     * @param simulationTime
     * total time on an intersection
     * @param arrivalProbability
     * the probability a vehicle arrives
     * @param roadNames
     * names of the road
     * @param maxGreenTimes
     * the maximum time the green light is on
     * @param numRoads
     * the number of roads
     */
    public static void simulate(int simulationTime, double arrivalProbability, String[] roadNames,
                                int[] maxGreenTimes, int numRoads) throws Exception {
        if(simulationTime < 0 || arrivalProbability < 0.0 || arrivalProbability > 1.0 || numRoads <= 0){
            System.out.print("NO SIMULATION");
            return;
        }

        int totalTime = 0;
        int totalVehicles = 0;
        double avgWaitTime;
        int totalWaitTime = 0;
        int longestWaitTime = 0;
        int timeStep = 1;

        TwoWayRoad[] roads = new TwoWayRoad[numRoads];
        for (int i = 0; i < numRoads; i++){
            roads[i] = new TwoWayRoad(roadNames[i], maxGreenTimes[i]);
        }
        Intersection intersection = new Intersection(roads);
        BooleanSource arrival = new BooleanSource(arrivalProbability);
        for (int i = 0; i < simulationTime; i++){
            if(arrival.occurs()) {
                Vehicle vehicle = new Vehicle(timeStep);

                int roadIndex = (int) (Math.random() * (numRoads - 1)) + 1;
                int wayIndex = (int) (Math.random() * 1);
                int laneIndex = (int) (Math.random() * 2);

                intersection.enqueueVehicle(roadIndex, wayIndex, laneIndex , vehicle);

                System.out.println("Car[ " + vehicle.getSerialId() + "] entered " +
                        roads[roadIndex].getName() + "going " + ((wayIndex == 1) ? "BACKWARD": "FORWARD")
                        + " in" + ((laneIndex == 2 && wayIndex == 1) ? "LEFT lane":
                        (laneIndex == 2 && wayIndex == 0) ? "RIGHT lane":
                                (laneIndex == 0 && wayIndex == 0) ? "LEFT lane":
                                        (laneIndex == 0 && wayIndex == 1)? "RIGHT lane": "MIDDLE lane"));

                intersection.timeStep();

            }
            maxGreenTimes[0]--;
        }
    }
}
