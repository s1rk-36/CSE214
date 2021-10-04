/**
 * Kristian Hajredinaj 113367328 R04
 */

import java.io.Serializable;
import java.util.*;

public class StorageTable extends HashMap implements Serializable{

    private static int serialVersionUID;
    private HashMap<Integer, Storage> map;

    /**
     * no arg constructor
     */
    public StorageTable(){
        map = new HashMap<>();
    }

    /**
     *
     * @param storageID
     * the id of the storage
     * @param storage
     * the storage to be put
     * @throws IllegalArgumentException
     * if preconditions are violated
     *
     */
    public void putStorage(int storageID, Storage storage) throws IllegalArgumentException{
        if(storage == null || storageID < 0)
            throw new IllegalArgumentException();

        map.put(storageID, storage);
    }

    /**
     *
     * @param storageID
     * id of storage
     * @return
     * storage with that key
     */
    public Storage getStorage(int storageID){
        Storage temp;
        if (!map.containsKey(storageID))
            return null;
        temp = map.get(storageID);
        return temp;
    }

    /**
     *
     * @param storageID
     * id of storage to be removed
     */
    public void removeStorage(int storageID){
        if( storageID < 0)
            throw new IllegalArgumentException();
        map.remove(storageID);
    }

    /**
     *
     * @return
     * a string with the info of the table
     */
    public String toString(){

        StringBuilder info = new StringBuilder(String.format("%-20s%-30s%-30s", "Box#", "Contents", "Owner"));
        info.append("\n").append("-".repeat(info.length()));

        ArrayList<Integer> sortedKeys = new ArrayList<>(map.keySet());
        Collections.sort(sortedKeys);

        for(Integer x : sortedKeys){
            info.append("\n").append(String.format("%-20d%-30s%-30s", map.get(x).getId(), map.get(x).getContents(),
                    map.get(x).getClient()));
        }


        return info.toString();
    }

}
