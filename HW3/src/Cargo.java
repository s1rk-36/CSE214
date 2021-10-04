/**
 * Kristian Hajredinaj
 * 113367328
 * Recitation 4
 */

public class Cargo {

    private String name;
    private double weight;
    private CargoStrength strength;

    /**
     * constructor to make a cargo
     * @param initName
     * name of cargo
     * @param initWeight
     * weight of cargo
     * @param initStrength
     * strength of cargo
     * @throws IllegalArgumentException
     * is no name is entered or invalid weight
     */
    public Cargo(String initName, double initWeight, CargoStrength initStrength)
    throws IllegalArgumentException{
        if(initName == null || initWeight <= 0) {
            throw new IllegalArgumentException();
        } else {
            name = initName;
            weight = initWeight;
            strength = initStrength;
        }
    }

    /**
     *
     * @return
     * name of cargo
     */
    public String getName(){
        return name;
    }

    /**
     *
     * @return
     * weight of cargo
     */
    public double getWeight(){
        return weight;
    }

    /**
     *
     *
     * @return
     * strength of cargo
     */

    public CargoStrength getStrength(){
        return strength;
    }


}
