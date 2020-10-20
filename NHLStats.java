/* NHLStats class
 * <Jerry Guo> <2019.10.16>
 */
import java.util.*;

public class NHLStats {
    private List<PlayerRecord> playerRecord;
    private ArrayList <String> allTheTeam;
    private ArrayList <Integer> allThePenaltiesMinutes;
    private ArrayList <Integer> allTheGameWinningGoals;

    //constructor
    public NHLStats(){
        playerRecord = new List<PlayerRecord>();
        allTheTeam = new ArrayList <String>();
        allThePenaltiesMinutes = new ArrayList <Integer>();
        allTheGameWinningGoals = new ArrayList <Integer>();
    }

    //Add player record to the list
    public void add (PlayerRecord player){
        playerRecord.add(player);
    }

    //Calculate the player who gets the most points
    public int mostPoints(){
        PlayerRecord player = playerRecord.first();
        int max = 0;

        while (player!=null){
            if (player.getGoalsScored()+player.getAssists() > max) {
                max = player.getGoalsScored()+player.getAssists();
            }
            player = playerRecord.next();
        }

        return max;
    }

    //Display the player who gets the most points
    public void displayMostPoints(int max){
        PlayerRecord player = playerRecord.first();

        while (player!=null){
            if (player.getGoalsScored()+player.getAssists() == max) {
                System.out.println("Player: " + player.getName() + " Points: " +
                        max + " Team: " + player.getTeamName());
            }
            player = playerRecord.next();
        }
    }

    //Calculate the player who gets the most penalties minutes
    public int mostAggressive(){
        PlayerRecord player = playerRecord.first();
        int max = 0;

        while (player!=null){
            if (player.getPenaltiesMinutes() > max) {
                max = player.getPenaltiesMinutes();
            }
            player = playerRecord.next();
        }
        return max;
    }

    //Display the player who gets the most penalties minutes
    public void displayMostAggressive(int max){
        PlayerRecord player = playerRecord.first();

        while (player!=null){
            if (player.getPenaltiesMinutes() == max) {
                System.out.println("Player: " + player.getName() +  " Team: " +
                        player.getTeamName() + " Position: " + player.getPosition());
            }
            player = playerRecord.next();
        }
    }

    //Calculate the player who gets the most game winning goals
    public int mostValuablePlayers(){
        PlayerRecord player = playerRecord.first();
        int max = 0;

        while (player!=null){
            if (player.getGameWinningGoals() > max) {
                max = player.getGameWinningGoals();
            }
            player = playerRecord.next();
        }
        return max;
    }

    //Display the player who gets the most game winning goals
    public void displayMostValuablePlayers(int max){
        PlayerRecord player = playerRecord.first();

        while (player!=null){
            if (player.getGameWinningGoals() == max) {
                System.out.println("Player: " + player.getName() +  " Team: " +
                        player.getTeamName());
            }
            player = playerRecord.next();
        }
    }

    //Calculate the player who gets the most shots on goal
    public int mostPromisingPlayers(){
        PlayerRecord player = playerRecord.first();
        int max = 0;

        while (player!=null){
            if (player.getShotsOnGoal() > max) {
                max = player.getShotsOnGoal();
            }
            player = playerRecord.next();
        }
        return max;
    }

    //Display the player who gets the most shots on goal
    public void displayMostPromisingPlayer(int max){
        PlayerRecord player = playerRecord.first();

        while (player!=null){
            if (player.getShotsOnGoal() == max) {
                System.out.println("Player: " + player.getName() +  " Team: " +
                        player.getTeamName());
            }
            player = playerRecord.next();
        }
    }

    //Add all the team names into the ArrayList allTheTeam
    public void getAllTheTeam(){
        PlayerRecord player = playerRecord.first();

        while (player!=null){
            String team = player.getTeamName();
            if (!allTheTeam.contains(team)){
                allTheTeam.add(team);
            }
            player = playerRecord.next();
        }
    }

    //Calculate the team who gets the most penalties minutes
    //and the team who gets the most game winning goals
    public void sum(){
        //Initialize the elements in ArrayList allThePenaltiesMinutes
        for (int i=0; i<allTheTeam.size(); i++){
            allThePenaltiesMinutes.add(0);
        }

        //Initialize the elements in ArrayList allTheGameWinningGoals
        for (int i=0; i<allTheTeam.size(); i++){
            allTheGameWinningGoals.add(0);
        }

        PlayerRecord player = playerRecord.first();

        while (player!=null){
            String team = player.getTeamName();
            int i = allTheTeam.indexOf(team); //Find the index of the team name in the ArrayList allTheTeam
            int pm = allThePenaltiesMinutes.get(i); //Get the sum of PenaltiesMinutes from the last calculation
            int gwg = allTheGameWinningGoals.get(i); //Get the sum of GameWinningGoals from the last calculation
            int pm2 = player.getPenaltiesMinutes(); //Get the new PenaltiesMinutes value
            int gwg2 = player.getGameWinningGoals(); //Get the new GameWinningGoals value

            allThePenaltiesMinutes.set(i, pm+pm2); //Update the sum of PenaltiesMinutes
            allTheGameWinningGoals.set(i, gwg+gwg2); //Update the sum of GameWinningGoals

            player = playerRecord.next();
        }
    }

    //Display the team who gets the most penalties minutes
    public void displayMostAggressiveTeam(){
        int mostPM = Collections.max(allThePenaltiesMinutes);
        int i = allThePenaltiesMinutes.indexOf(mostPM);
        System.out.println(allTheTeam.get(i));
    }

    //Display the team who gets the most game winning goals
    public void displayMostValuableTeam(){
        int mostGWG = Collections.max(allTheGameWinningGoals);
        int i = allTheGameWinningGoals.indexOf(mostGWG);
        System.out.println(allTheTeam.get(i));
    }

}
