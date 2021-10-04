//Kristian Hajredinaj     113367328     Recitation 4

import big.data.DataSource;
import java.text.SimpleDateFormat;
import java.util.*;


public class NeoDatabase {

    public static final String API_KEY = "uvtedn6pg8hwHVmiaRuNInWBn7lr5DbojfRDIXet";
    public static final String API_ROOT = "https://api.nasa.gov/neo/rest/v1/neo/browse?";
    private ArrayList<NearEarthObject> neoDatabase;

    /**
     * no arg constructor
     */
    public NeoDatabase(){
        neoDatabase = new ArrayList<>();
    }

    /**
     *
     * @param pageNumber
     * the page number
     * @return
     * the URL
     * @throws IllegalArgumentException
     * if the page number is out of range
     */
    public String buildQueryURL(int pageNumber) throws IllegalArgumentException{
        if (pageNumber < 0 || pageNumber > 715)
            throw new IllegalArgumentException("Invalid range");

        return API_ROOT + "page=" + pageNumber + "&api_key=" + API_KEY;
    }

    public void adAll(String queryURL) throws IllegalArgumentException{
        if (queryURL == null)
            throw new IllegalArgumentException();

        DataSource ds = DataSource.connectJSON(queryURL);
        ds.load();
        NearEarthObject[] temp = ds.fetchArray("NearEarthObject",
                "near_earth_objects/neo_reference_id",
                "near_earth_objects/name",
                "near_earth_objects/absolute_magnitude_h",
                "near_earth_objects/estimated_diameter/kilometers/estimated_diameter_min",
                "near_earth_objects/estimated_diameter/kilometers/estimated_diameter_max",
                "near_earth_objects/is_potentially_hazardous_asteroid",
                "near_earth_objects/close_approach_data/epoch_date_close_approach",
                "near_earth_objects/close_approach_data/miss_distance/kilometers",
                "near_earth_objects/close_approach_data/orbiting_body");

        neoDatabase = new ArrayList<>(Arrays.asList(temp));
    }

    /**
     *
     * @param comp
     * the type of comparator
     * @throws IllegalArgumentException
     * if the comparator is null
     */
    public void sort(Comparator<NearEarthObject> comp) throws IllegalArgumentException{
        if (comp == null)
            throw new IllegalArgumentException();

        neoDatabase.sort(comp);
    }

    /**
     * prints the list of objects as a table
     */
    public void printTable(){

        String header = String.format("%-15s%-25s%-20s%-20s%-20s%-20s%-20s%-20s",
                "ID", "Name", "Mag.", "Diameter", "Danger", "Close Date", "Miss Dist", "Orbits");
        System.out.print(header + "\n");
        System.out.println("=".repeat(header.length()));


        for (NearEarthObject nearEarthObject : neoDatabase) {


            SimpleDateFormat sdf = new SimpleDateFormat("M/dd/yyyy");
            String date = sdf.format(nearEarthObject.getClosestApproachDate());

            System.out.printf("%-10d%-30s%-20.1f%-20.3f%-20s%-20s%-20.0f%-10s",
                    nearEarthObject.getReferenceID(),
                    nearEarthObject.getName(), nearEarthObject.getAbsoluteMagnitude(),
                    nearEarthObject.getAverageDiameter() , nearEarthObject.getIsDangerous(),
             date ,  nearEarthObject.getMissDistance(),
             nearEarthObject.getOrbitingBody());
            System.out.println();
        }
    }


}
