

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.*;
import java.util.*;
import src.*;

public class Main {

  public static void main(String[] args) throws IOException, ParseException, SQLException, ClassNotFoundException {

      BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      Date gameDate;

      System.out.println("Enter the game date:");
      gameDate = sdf.parse(inp.readLine());
     
      GameDAO gameDAO = new GameDAO();
      
  

     //fill your code
      
      ArrayList<Game> gameList = new ArrayList<Game>();
      
      gameList = (ArrayList<Game>) gameDAO.listOrders(gameDate);
      
      for(Game g :gameList)
    	  System.out.println(g.getTeam1().getTeamName() + " Vs " + g.getTeam2().getTeamName());

  }

}

