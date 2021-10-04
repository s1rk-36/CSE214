//Kristian Hajredinaj     113367328     Recitation 4
import java.util.Comparator;
import java.util.Date;

public class ApproachDateComparator implements Comparator<NearEarthObject> {
    @Override
    /**
     * compares the approach dates
     */
    public int compare(NearEarthObject left, NearEarthObject right) {
        return left.getClosestApproachDate().compareTo(right.getClosestApproachDate());
    }
}
