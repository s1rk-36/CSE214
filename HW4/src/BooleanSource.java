/**
 * Kristian Hajredinaj ID: 113367328 Recitation 4
 */


public class BooleanSource {

    private double probability;

    /**
     *
     * @param initProbability
     * probability
     * @throws IllegalArgumentException
     * if the given probability is not within the range
     */
    public  BooleanSource(double initProbability) throws IllegalArgumentException{
        if (initProbability <= 0 || initProbability > 1){
            throw new IllegalArgumentException();
        }

        probability = initProbability;

    }

    /**
     *
     * @return
     * the probability
     */
    public double getProb(){
        return probability;
    }

    /**
     *
     * @param newProbability
     * sets the probability
     */
    public void setProb(double newProbability){
        probability = newProbability;
    }

    /**
     *
     * @return
     * true if the probability was within range
     */
    public boolean occurs(){
        return (Math.random() < probability);
    }

}
