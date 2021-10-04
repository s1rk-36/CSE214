/**
 *
 * @author //Kristian Hajredinaj ID; 113367328 Recitation 4
 *
 * Main Method
 */

import java.util.Locale;
import java.util.Scanner;

/**
 * main method with all the input
 * and a switch case for the option menu
 */
public class TeamManager {
    public static void main(String[] arg) throws FullTeamException, CloneNotSupportedException {

        Scanner input = new Scanner(System.in);
        int MAX_TEAMS = 5;
        int teamIndex = 0;
        Team[] teams = new Team[MAX_TEAMS];
        for(int i = 0; i < MAX_TEAMS; i++){
            teams[i] = new Team();
        }

        System.out.print("Welcome to TeamManager\n" +
                "Team 1 is currently selected\n\n");
        String menu  =
                ("A) Add Player\n" +
                "G) Get Player\n" +
                "L)Get leader in a stat\n" +
                "R) Remove a player\n" +
                "P) Print all players\n" +
                "S) Size of team\n" +
                "T) Select team\n" +
                "C) Clone team\n" +
                "E) Team equals\n" +
                "U) Update stat\n" +
                "Q) Quit\n" +
                "Select menu Option: ");
        System.out.print(menu);

        boolean gameOver = false;

        while (!gameOver) {

            String str = input.nextLine();
            str = str.toLowerCase(Locale.ROOT);
            switch (str) {
                case "a":
                    Player p = new Player();
                    System.out.print("Enter the player's name: ");
                    String name = input.nextLine();
                    p.setName(name);
                    System.out.print("Enter the number of hits: ");
                    int numHits = input.nextInt();
                    p.setNumHits(numHits);
                    System.out.print("Enter the number of errors: ");
                    int numErrors = input.nextInt();
                    p.setNumErrors(numErrors);
                    System.out.print("Enter the position: ");
                    int position = input.nextInt();
                    teams[teamIndex].addPlayer(p, position);
                    if (position >= 1 && position <= teams[teamIndex].size()) {
                        System.out.print("Player added: " + p.toString() + "\n");
                    }
                    System.out.print(menu);
                    break;
                case "g":
                    System.out.print("Enter the position: ");
                    position = input.nextInt() - 1;
                    System.out.print(teams[teamIndex].getPlayer(position).toString() + "\n");
                    System.out.print(menu);
                    break;
                case "l":
                    System.out.print("Enter the stat: ");
                    String stat = input.nextLine();
                    if (stat.equals("errors") || stat.equals("hits")) {
                        System.out.print("Leader in " + stat + ": " + teams[teamIndex].getLeader(stat).toString());
                        System.out.println();
                    } else {
                        System.out.print("No such statistic\n");
                    }
                    System.out.print(menu);
                    break;
                case "r":
                    System.out.print("Enter the position: ");
                    position = input.nextInt();

                    if (position + 1 > 1 && position <= teams[teamIndex].size()) {
                        System.out.println("Player Removed at position " + position);
                        System.out.println(teams[teamIndex].getPlayer(position - 1).getName() +
                                " has been removed from the team.");
                        teams[teamIndex].removePlayer(position);
                    }
                    System.out.println();
                    System.out.print(menu);
                    break;
                case "p":
                    System.out.print("Select team index: ");
                    int newIndex = input.nextInt() - 1;
                    System.out.print("\n" + teams[newIndex].toString());
                    teams[newIndex].printAllPlayers();
                    System.out.println();
                    System.out.print(menu);
                    break;
                case "s":
                    System.out.print("There are " + teams[teamIndex].size() + " player(s) in the team.\n");
                    System.out.println();
                    System.out.print(menu);
                    break;
                case "t":
                    System.out.print("Enter team index to select: ");
                    int newTeamIndex = input.nextInt() - 1;
                    if (newTeamIndex + 1 > MAX_TEAMS)
                        System.out.print("Invalid index for team.");
                    else {
                        teamIndex = newTeamIndex;
                        System.out.print("Team " + (teamIndex + 1) + " has been selected");
                    }
                    System.out.print("\n");
                    System.out.print(menu);
                    break;
                case "c":
                    System.out.print("Select team to clone from: ");
                    int clone1 = input.nextInt() - 1;
                    System.out.print("Select team to clone to: ");
                    int clone2 = teamIndex = input.nextInt() - 1;
                    teams[clone2] = (Team) teams[clone1].clone();
                    System.out.print("Team " + clone2 + " has been copies to team " + clone1);
                    System.out.println();
                    System.out.print(menu);
                    break;
                case "e":
                    System.out.print("Select first team index: ");
                    int teamIndex1 = input.nextInt() - 1;
                    System.out.print("Select second team index: ");
                    int teamIndex2 = input.nextInt() - 1;
                    if(teams[teamIndex1].equals(teams[teamIndex2]))
                        System.out.print("The teams are equal\n");
                    else
                        System.out.print("These teams are not equal\n");
                    System.out.print(menu);
                    break;
                case "u":
                    System.out.print("Enter the player to update: ");
                    String playerName = input.nextLine();
                    boolean playerExists = false;
                    int number = 0;
                    for (int i = 0; i < teams[teamIndex].size(); i++){
                        if (teams[teamIndex].getPlayer(i).getName().equals(playerName)) {
                            playerExists = true;
                            number = i;
                            break;
                        }
                    }
                    if (playerExists){
                        System.out.print("Enter stat to update: ");
                        stat = input.nextLine();
                        if (stat.equals("errors")){
                            System.out.print("Enter the new number of errors: ");
                            numErrors = input.nextInt();
                            teams[teamIndex].getPlayer(number).setNumErrors(numErrors);
                            System.out.print("Updated " + teams[teamIndex].getPlayer(number).getName() +
                                    " errors\n");
                        } else {
                            System.out.print("Enter the new number of hits: ");
                            numHits = input.nextInt();
                            teams[teamIndex].getPlayer(number).setNumHits(numHits);
                            System.out.print("Updated " + teams[teamIndex].getPlayer(number).getName() +
                                    " hits\n");
                        }
                    } else
                        System.out.print("Player doesn't exist\n");
                    System.out.println();
                    System.out.print(menu);
                    break;
                case "q":
                    gameOver = true;
                    break;
                default:
                    break;
            }
        }

        System.out.print("See ya");
    }
}

