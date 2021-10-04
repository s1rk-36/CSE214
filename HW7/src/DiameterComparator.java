//Kristian Hajredinaj     113367328     Recitation 4
import java.util.Comparator;

public class DiameterComparator implements Comparator<NearEarthObject> {
    @Override
    /**
     * compares the diameters
     */
    public int compare(NearEarthObject left, NearEarthObject right) {
        return Double.compare(left.getAverageDiameter(), right.getAverageDiameter());
    }
}
