/**
 * Kristian Hajredinaj 113367328 R04
 */

import java.io.Serializable;

public class Storage implements Serializable{

    static long serialVersionUID;
    private int id;
    private String client;
    private String contents;

    /**
     * constructor
     */
    public Storage(){}

    /**
     *
     * @return
     * the id of the storage
     */
    public int getId(){
        return id;
    }

    /**
     *
     * @return
     * returns the client
     */
    public String getClient(){
        return client;
    }

    /**
     *
     * @return
     * contents of the storage
     */
    public String getContents(){
        return contents;
    }

    /**
     *
     * @param id
     * sets the id to a new id
     */
    public void setId(int id){ this.id = id; }

    /**
     *
     * @param client
     * sets the client to a new client
     */
    public void setClient(String client){ this.client = client; }

    /**
     *
     * @param contents
     * sets the content to a new content
     */
    public void setContents(String contents){ this.contents = contents; }
}