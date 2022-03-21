package de.jgu.football;

/**
 * Class to hold Football-Data from a CSV File.
 *
 */
public class FootballDTO {

	private String Team;
	private int Games;
	private int Wins;
	private int Losses;
	private int Draws;
	private int Goals;
	private int GoalsAllowed;
	private int Points;
	
	/**
	 * Empty constructor
	 */
	public FootballDTO() {
		// Empty Constructor
	}
	
	@Override
	public String toString() {
		String theString = "Team: " + Team;
		theString += ", Games: " + Games;
		theString += ", Wins: " + Wins;
		theString += ", Losses: " + Losses;
		theString += ", Draws: " + Draws;
		theString += ", Goals: " + Goals;
		theString += ", GoalsAllowed: " + GoalsAllowed;
		theString += ", Points: " + Points;
		return theString;
	}
	
	//getter and setter	
	public String getTeam() {
		return Team;
	}
	public void setTeam(String team) {
		Team = team;
	}
	public int getGames() {
		return Games;
	}
	public void setGames(int games) {
		Games = games;
	}
	public int getWins() {
		return Wins;
	}
	public void setWins(int wins) {
		Wins = wins;
	}
	public int getLosses() {
		return Losses;
	}
	public void setLosses(int losses) {
		Losses = losses;
	}
	public int getDraws() {
		return Draws;
	}
	public void setDraws(int draws) {
		Draws = draws;
	}
	public int getGoals() {
		return Goals;
	}
	public void setGoals(int goals) {
		Goals = goals;
	}
	public int getGoalsAllowed() {
		return GoalsAllowed;
	}
	public void setGoalsAllowed(int goalsAllowed) {
		GoalsAllowed = goalsAllowed;
	}
	public int getPoints() {
		return Points;
	}
	public void setPoints(int points) {
		Points = points;
	}
}
