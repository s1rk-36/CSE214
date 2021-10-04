//Kristian Hajredinaj     113367328     Recitation 4
import java.util.Comparator;

public class ReferenceIDComparator implements Comparator<NearEarthObject> {
    @Override
    /**
     * compares the IDs
     */
    public int compare(NearEarthObject left, NearEarthObject right) {
        return Integer.compare(left.getReferenceID(), right.getReferenceID());
    }
}
