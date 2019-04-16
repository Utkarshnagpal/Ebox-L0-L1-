
public class Match {

	String teamOne;
	String teamTwo;
	String venue;
	String matchDate;
	
	//Constructor (String, String, String, String)
	public Match(String teamOne, String teamTwo, String venue, String matchDate) {
		super();
		this.teamOne = teamOne;
		this.teamTwo = teamTwo;
		this.venue = venue;
		this.matchDate = matchDate;
	}

	//Getters and Setters
	public String getTeamOne() {
		return teamOne;
	}

	public void setTeamOne(String teamOne) {
		this.teamOne = teamOne;
	}

	public String getTeamTwo() {
		return teamTwo;
	}

	public void setTeamTwo(String teamTwo) {
		this.teamTwo = teamTwo;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(String matchDate) {
		this.matchDate = matchDate;
	}
	
	public void displayMatch(Match m, Integer i){
		
	}

	@Override
	public String toString() {
		return "TeamOne : " + teamOne + "\nTeamTwo : " + teamTwo + "\nVenue : " + venue + "\nMatchDate : " + matchDate;
	}
	
	
}
