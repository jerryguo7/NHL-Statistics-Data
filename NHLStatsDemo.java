/* The NHLStatsDemo class will demonstrate all the methods that have developed
 * <Jerry Guo> <2019.10.16>
 */
import java.util.*;
import java.io.*;

public class NHLStatsDemo {
    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the filename to read from: ");
        String filename = keyboard.nextLine();

        File file = new File(filename);
        Scanner inputFile = new Scanner(file);

        NHLStats nhlStats = new NHLStats();
        String line, name, position, teamName;
        int gamesPlayed, goalsScored, assists, penaltiesMinutes, shotsOnGoal, gameWinningGoals;
        PlayerRecord playerRecord=null;
        StringTokenizer token;

        //Store all the information
        while (inputFile.hasNext()) {
            line = inputFile.nextLine();
            token = new StringTokenizer(line, "\t");
            name = token.nextToken();
            position = token.nextToken();
            teamName = token.nextToken();
            gamesPlayed= Integer.parseInt((token.nextToken()));
            goalsScored= Integer.parseInt((token.nextToken()));
            assists= Integer.parseInt((token.nextToken()));
            penaltiesMinutes= Integer.parseInt((token.nextToken()));
            shotsOnGoal= Integer.parseInt((token.nextToken()));
            gameWinningGoals= Integer.parseInt((token.nextToken()));

            playerRecord = new PlayerRecord(name, position, teamName,gamesPlayed, goalsScored,
                    assists, penaltiesMinutes, shotsOnGoal, gameWinningGoals);
            nhlStats.add(playerRecord);
        }

        inputFile.close();

        //Demonstrate the methods
        System.out.println("NHL Results Summary");
        System.out.println("\nPlayers with highest points and their teams:");
        nhlStats.displayMostPoints(nhlStats.mostPoints());
        System.out.println("\nMost aggressive players, their teams and their positions:");
        nhlStats.displayMostAggressive(nhlStats.mostAggressive());
        System.out.println("\nMost valuable players and their teams:");
        nhlStats.displayMostValuablePlayers(nhlStats.mostValuablePlayers());
        System.out.println("\nMost promising players and their teams:");
        nhlStats.displayMostPromisingPlayer(nhlStats.mostPromisingPlayers());

        nhlStats.getAllTheTeam();
        nhlStats.sum();

        System.out.println("\nTeams that had the most number of penalty minutes:");
        nhlStats.displayMostAggressiveTeam();
        System.out.println("\nTeams that had the most number of game winning goals:");
        nhlStats.displayMostValuableTeam();


    }
}
