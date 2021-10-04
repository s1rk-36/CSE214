//Kristian Hajredinaj     113367328     Recitation 4

import java.util.Date;

public class NearEarthObject {

    private int referenceID;
    private String name;
    private double absoluteMagnitude;
    private double averageDiameter;
    private boolean isDangerous;
    private Date closestApproachDate;
    private double missDistance;
    private String orbitingBody;

    /**
     *
     * @param referenceID
     * the reference ID
     * @param name
     * the name of the object
     * @param absoluteMagnitude
     * the magnitude of the object
     * @param minDiameter
     * minimum diameter
     * @param maxDiameter
     * maximum diameter
     * @param isDangerous
     * if it dangerous
     * @param closestDateTimestamp
     * closest time they approach
     * @param missDistance
     * the miss distance
     * @param orbitingBody
     * where it is orbiting
     */
    public NearEarthObject(int referenceID, String name, double absoluteMagnitude, double minDiameter,
                           double maxDiameter, boolean isDangerous, long closestDateTimestamp,
                           double missDistance, String orbitingBody){
        this.referenceID = referenceID;
        this.name = name;
        this.absoluteMagnitude = absoluteMagnitude;
        averageDiameter = (maxDiameter - minDiameter) / 2;
        this.isDangerous = isDangerous;
        this.missDistance = missDistance;
        this.orbitingBody = orbitingBody;
        closestApproachDate = new Date(closestDateTimestamp);
    }

    /**
     *
     * @return
     * the reference ID
     */
    public int getReferenceID(){
        return referenceID;
    }

    /**
     *
     * @param referenceID
     * the new reference ID to be set to
     */
    public void setReferenceID(int referenceID){
        this.referenceID = referenceID;
    }

    /**
     *
     * @return
     * the name of the object
     */
    public String getName(){
        return name;
    }

    /**
     *
     * @param name
     * the new name to be set to
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     *
     * @return
     * the abs magnitude
     */
    public double getAbsoluteMagnitude(){
        return absoluteMagnitude;
    }

    /**
     *
     * @param absoluteMagnitude
     * the new abs magnitude to be set to
     */
    public void setAbsoluteMagnitude(double absoluteMagnitude){
        this.absoluteMagnitude = absoluteMagnitude;
    }

    /**
     *
     * @return
     * the average diameter
     */
    public double getAverageDiameter(){
        return averageDiameter;
    }

    /**
     *
     * @param averageDiameter
     * new the new avg dia to be set to
     */
    public void setAverageDiameter(double averageDiameter){
        this.averageDiameter = averageDiameter;
    }

    /**
     *
     * @return
     * true or false if it is dangerous
     */
    public boolean getIsDangerous(){
        return isDangerous;
    }

    /**
     *
     * @param isDangerous
     * if it dangerous
     */
    public void setDangerous(boolean isDangerous){
        this.isDangerous = isDangerous;
    }

    /**
     *
     * @return
     * the closest approach date
     */
    public Date getClosestApproachDate(){
        return closestApproachDate;
    }

    /**
     *
     * @param closestApproachDate
     * the new closest approach date
     */
    public void setClosestApproachDate(Date closestApproachDate){
        this.closestApproachDate = closestApproachDate;
    }

    /**
     *
     * @return
     * the miss distance
     */
    public double getMissDistance(){
        return missDistance;
    }

    /**
     *
     * @param missDistance
     * the new miss distance
     */
    public void setMissDistance(double missDistance){
        this.missDistance = missDistance;
    }

    /**
     *
     * @return
     * the orbiting body
     */
    public String getOrbitingBody(){
        return orbitingBody;
    }

    /**
     *
     * @param orbitingBody
     * the new orbiting body
     */
    public void setOrbitingBody(String orbitingBody){
        this.orbitingBody = orbitingBody;
    }

}
