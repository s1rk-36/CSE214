/**
 * Kristian Hajredinaj ID: 113367328 Recitation 4
 */


import java.util.*;

public class VehicleQueue {

    private List<Vehicle> vehicles;
    private int front;
    private int rear;
    private int counter = 0;

    /**
     * constructor for the queue
     */
    public VehicleQueue() {
        front = 0;
        rear = 0;
        vehicles = new ArrayList<>();
    }

    /**
     *
     * @return
     * true if the queue is empty
     */
    public boolean isEmpty() {
        return (front == -1);
    }

    /**
     *
     * @param vehicle
     * vehicle object
     */
    public void enqueue(Vehicle vehicle) {
        vehicles.set(rear, vehicle);
        rear++;
        counter++;
    }

    /**
     *
     * @return
     * vehicles that are dequeued
     * @throws Exception
     * if the list is empty
     */
    public Vehicle dequeue() throws Exception {
        Vehicle answer;
        if (front == rear) {
           throw new Exception("List is empty");
        }
        else {
            answer = vehicles.get(0);
            for (int i = 0; i < rear - 1; i++) {
                vehicles.set(i, vehicles.get(i + 1));
            }
            rear--;
            counter--;
        }

        return answer;
    }

    /**
     *
     * @return
     * size of the queue
     */
    public int size(){
        return counter;
    }
}
