/**
 *
 * @author //Kristian Hajredinaj ID; 113367328 Recitation 4
 *
 * Team Class
 */

public class Team {

    public static final int MAX_PLAYERS = 40;
    private Player[] players;
    private int counter = 0;

    /**
     * @constructor
     * makes an array of no arg players
     */
    public Team(){
        this.players = new Player[MAX_PLAYERS];
    }

    /**
     *
     * @return
     * a clone of a team object
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException {
        Team teamCopy = new Team();
        for (int i = 0; i < counter; i++) {
            teamCopy.players[i] = (Player) players[i].clone();
        }
        teamCopy.counter = counter;
        return teamCopy;
    }

    /**
     *
     * @param obj
     * any Object
     * @return
     * true if 2 Team Objects are true
     */
    public boolean equals(Object obj) {
        if (obj instanceof Team) {
            Team t = (Team) obj;
            for (int i = 0; i <= counter; i++) {
                return t.players[i].equals(players[i]) && t.counter == counter;
            }
        }
        return false;
    }

    /**
     *
     * @return
     * size of team
     *
     */
    public int size() {
        return counter;
    }

    /**
     *
     * @param p
     * a Player Object
     * @param position
     * Position in the team
     * @throws IllegalArgumentException
     * if the position is illegal
     * @throws FullTeamException
     * if the team already has 40 players
     *
     * add a Player to a Team array
     * moves every other player to the right
     */
    public void addPlayer(Player p, int position) throws IllegalArgumentException, FullTeamException {
        try {
            if (position < 1 || position > counter + 1)
                throw new IllegalArgumentException();
            if (counter > 40)
                throw new FullTeamException();
            for (int i = counter; i >= (position - 1); i--) {
                players[i + 1] = players[i];
            }
            players[position - 1] = p;
            counter++;
        } catch(IllegalArgumentException e) {
            System.out.print("The position entered is not in valid range\n");
        } catch(FullTeamException e){
            System.out.print(e.getMessage());
        }
    }

    /**
     *
     * @param position
     * position of player in the team
     * @throws IllegalArgumentException
     * if the position in invalid
     */
    public void removePlayer(int position) throws IllegalArgumentException {
        try {
            if (position + 1 < 1 || position >= counter)
                throw new IllegalArgumentException();

            for(int i = (position - 1); i < counter; i++) {
                players[i] = players[i + 1];
            }
            counter--;
        } catch(IllegalArgumentException e){
            System.out.print("The position entered is not in valid range");
        }
    }

    /**
     *
     * @param position
     * position of player in the team
     * @return
     * the player at that position
     * @throws IllegalArgumentException
     * if the position is invalid
     */
    public Player getPlayer(int position) throws IllegalArgumentException {
        try {
            if (position < 0 || position > counter + 1)
                throw new IllegalArgumentException();
        } catch(IllegalArgumentException e){
            System.out.print("The position entered is not in valid range");
        }
        return players[position];
    }

    /**
     *
     * @param stat
     * the type of stat
     * @return
     * the Player with the best
     * specified stat
     * @throws IllegalArgumentException
     * if the input is not a valid stat
     */
    public Player getLeader(String stat) throws IllegalArgumentException {
        try {

            if (!stat.equals("hits") && !stat.equals("errors"))
                throw new IllegalArgumentException();
        } catch(IllegalArgumentException e){
            System.out.print("The entered stat was neither \"hits\" nor \"errors\"");
        }
        Player p = players[0];

        if (stat.equals("hits")) {
            int highestHits = players[0].getNumHits();
            for (int i = 0; i < counter; i++) {
                if (players[i].getNumHits() > highestHits) {
                    highestHits = players[i].getNumHits();
                    p = players[i];
                }
            }
        }
        else if (stat.equals("errors")) {
            int lowestError = players[0].getNumErrors();
            for (int i = 0; i < counter; i++) {
                if (players[i].getNumErrors() < lowestError) {
                    lowestError = players[i].getNumErrors();
                    p = players[i];
                }
            }
        }
        return p;

    }

    /**
     * prints the array of players
     */
    public void printAllPlayers(){
        for (int i = 0; i < counter; i++){
            System.out.print((i + 1) + String.format("%16s", players[i].getName()) +
                    String.format("%24s", players[i].getNumHits()) +
                    String.format("%12s", players[i].getNumErrors()) + "\n");
        }

    }

    /**
     *
     * @return
     * the header
     */
    public String toString(){
        String str1 = "Player#";
        String str2 = "Name";
        String str3 = "Hits";
        String str4 = "Errors";
        String info = str1 + String.format("%10s", str2)
                + String.format("%24s", str3) + String.format("%12s", str4) + "\n";
        return info + "-".repeat(info.length()) + "\n";
    }
}
