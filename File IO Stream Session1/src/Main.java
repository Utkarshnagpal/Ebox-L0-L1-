import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		/*
		//File IO Stream/Display Match Details from file
		
		//Reading matches.txt
		FileReader in = new FileReader("matches.txt");
		BufferedReader matchReader = new BufferedReader(in);
		
		//Get match list from file
		ArrayList<Match> matchList = (ArrayList<Match>) MatchFileStore.obtainMatchFromFile(matchReader);
		
		System.out.println("The Match Details are :");
		
		int len = matchList.size();
		
		for(int i = 0; i < len; i++){
			
			Match temp = matchList.get(i);
			System.out.println("Match " + (i+1));
			System.out.println(temp);
		}
		
		in.close();
		matchReader.close();
		*/
		
		
		//File IO Stream/ Simple File Write
		
		Scanner sc = new Scanner(System.in);
		
		String playerName;
		String teamName;
		String numberOfMatches;
		
		System.out.println("Enter the name of the player");
		playerName = sc.nextLine();
		System.out.println("Enter the team name");
		teamName = sc.nextLine();
		System.out.println("Enter the number of matches played");
		numberOfMatches = sc.nextLine();
		
		//Writer tools
		File f = new File("player.csv");
		FileWriter out = new FileWriter(f);
		BufferedWriter writer = new BufferedWriter(out);

		writer.write(playerName + "," + teamName + "," + numberOfMatches);

		
		//Closing resources
		writer.close();
		out.close();
		
		sc.close();
		
		
		
	}

}
