



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;


public class Main {

	 
	  public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
	      Player team = new Player();
	      PlayerDAO playerDAO = new PlayerDAO();
	      System.out.println("Player List");
	      List<Player> playerList = playerDAO.getAllPlayers();
	      playerDAO.displayPlayers(playerList);
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      System.out.println("Enter the player details to be updated");
	      System.out.println("Enter the player id");
	      Long id = Long.parseLong(br.readLine());
	      System.out.println("Enter the player name");
	      String name = br.readLine();
	      System.out.println("Enter the skill of the player");
	      String skill= br.readLine();
	      playerDAO.updatePlayerDetails(id,skill);
	      System.out.println("Updated player list");
    
	      //fill your code	
	      playerList = playerDAO.getAllPlayers();
	      playerDAO.displayPlayers(playerList);


	  }
	  

	  
	}
