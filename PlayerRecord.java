/* PlayerRecord class that defines a PlayerRecord object with name, position, teamName, gamesPlayed, goalsScored,
 * assists, penaltiesMinutes, shotsOnGoal, gameWinningGoals
 * <Jerry Guo> <2019.10.16>
 */
public class PlayerRecord {
    private String Name;
    private String Position;
    private String TeamName;
    private int GamesPlayed;
    private int GoalsScored;
    private int Assists;
    private int PenaltiesMinutes;
    private int ShotsOnGoal;
    private int GameWinningGoals;

    //constructors
    public PlayerRecord(){

    }

    public PlayerRecord(String name, String position, String teamName, int gamesPlayed, int goalsScored,
                        int assists, int penaltiesMinutes, int shotsOnGoal, int gameWinningGoals) {
        Name = name;
        Position = position;
        TeamName = teamName;
        GamesPlayed = gamesPlayed;
        GoalsScored = goalsScored;
        Assists = assists;
        PenaltiesMinutes = penaltiesMinutes;
        ShotsOnGoal = shotsOnGoal;
        GameWinningGoals = gameWinningGoals;
    }

    //getters and setters
    public String getName() {
        return Name;
    }

    public String getPosition() {
        return Position;
    }

    public String getTeamName() {
        return TeamName;
    }

    public int getGamesPlayed() {
        return GamesPlayed;
    }

    public int getGoalsScored() {
        return GoalsScored;
    }

    public int getAssists() {
        return Assists;
    }

    public int getPenaltiesMinutes() {
        return PenaltiesMinutes;
    }

    public int getShotsOnGoal() {
        return ShotsOnGoal;
    }

    public int getGameWinningGoals() {
        return GameWinningGoals;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public void setTeamName(String teamName) {
        TeamName = teamName;
    }

    public void setGamesPlayed(int gamesPlayed) {
        GamesPlayed = gamesPlayed;
    }

    public void setGoalsScored(int goalsScored) {
        GoalsScored = goalsScored;
    }

    public void setAssists(int assists) {
        Assists = assists;
    }

    public void setPenaltiesMinutes(int penaltiesMinutes) {
        PenaltiesMinutes = penaltiesMinutes;
    }

    public void setShotsOnGoal(int shotsOnGoal) {
        ShotsOnGoal = shotsOnGoal;
    }

    public void setGameWinningGoals(int gameWinningGoals) {
        GameWinningGoals = gameWinningGoals;
    }

    //toString
    public String toString() {
        return Name + " " + Position + " " + TeamName + " " + GamesPlayed + " " + GoalsScored + " " +
               Assists + " " + PenaltiesMinutes + " " + ShotsOnGoal + " " + GameWinningGoals;
    }

}
