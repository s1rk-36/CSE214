//Kristian Hajredinaj     113367328     Recitation 4
import java.util.Comparator;

public class MissDistanceComparator implements Comparator<NearEarthObject> {
    @Override
    /**
     * compares the miss distance
     */
    public int compare(NearEarthObject left, NearEarthObject right) {
        return Double.compare(left.getMissDistance(), right.getMissDistance());
    }
}
