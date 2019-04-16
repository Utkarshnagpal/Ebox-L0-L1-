package src;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GameDAO {
  
  
      public List<Game> listOrders(Date gameDate) throws SQLException, ClassNotFoundException      {
    	  

          Connection con = null;

          ResourceBundle rb = ResourceBundle.getBundle("mysql");
          String url = rb.getString("db.url");
          String user = rb.getString("db.username");
          String pass = rb.getString("db.password");

          try {
        	  Class.forName("com.mysql.jdbc.Driver");
          } catch (ClassNotFoundException ex) {
        	  Logger.getLogger(GameDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
          con = DriverManager.getConnection(url,user,pass);
          
          //fill your code
          
          ArrayList<Game>gameList = new ArrayList<Game>();
          
          java.sql.Date sDate = new java.sql.Date(gameDate.getTime());          
          String sql = "select team_id_1, team_id_2 from game where game_date=?";
          TeamDAO td = new TeamDAO();
          
          PreparedStatement pst = con.prepareStatement(sql);
          
          pst.setDate(1, sDate);
          
          ResultSet rs = pst.executeQuery();
              
          while(rs.next()){
        	  
        	  Team teamOne;
        	  Team teamTwo;
        	  teamOne = td.getTeamByID((long)rs.getInt(1));
        	  teamTwo = td.getTeamByID((long)rs.getInt(2));
        	          	  
        	  Game g = new Game(gameDate, teamOne, teamTwo);
        	  gameList.add(g);
          }
          
          return gameList;
      }
  }


