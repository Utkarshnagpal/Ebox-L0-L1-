import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MatchFileStore {
	
	
	public static List<Match> obtainMatchFromFile(BufferedReader matchReader) throws IOException{
		
		ArrayList<Match> matchList = new ArrayList<Match>();
		
		while(matchReader.ready()){
			
			String matchDetails = matchReader.readLine();
			
			String teamOne = matchDetails.substring(0, 5).trim();
			String teamTwo = matchDetails.substring(5, 10).trim();
			String venue = matchDetails.substring(10, 30).trim();
			String matchDate = matchDetails.substring(30, 40).trim();
			
			Match m = new Match(teamOne, teamTwo, venue, matchDate);
			
			matchList.add(m);
			
		}
		
		return matchList;
		
	}

}
