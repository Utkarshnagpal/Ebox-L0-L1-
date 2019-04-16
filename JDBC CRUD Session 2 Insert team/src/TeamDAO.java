


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class TeamDAO {
  
  public void createTeam(Team team) throws ClassNotFoundException, SQLException {
       ResourceBundle rb= ResourceBundle.getBundle("mysql");
      
      String url=rb.getString("db.url");
      String username=rb.getString("db.username");
      String pass=rb.getString("db.password");
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection(url,username,pass);
   
      //fill your code
      String query = "insert into team (id,name,coach,home_city_id) values (?, ?, ?, ?)";
      
      PreparedStatement ps = con.prepareStatement(query);
      ps.setInt(1, 9);
      ps.setString(2, team.getName());
      ps.setString(3, team.getCoach());
      ps.setLong(4, team.getCity().getCityId());
      
       int n=ps.executeUpdate();
       
       System.out.println("Team has been created");      
     
  }
  
   public List<Team> getAllTeams() throws ClassNotFoundException, SQLException{
      ResourceBundle rb= ResourceBundle.getBundle("mysql");
      
      String url=rb.getString("db.url");
      String user=rb.getString("db.username");
      String pass=rb.getString("db.password");
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection(url,user,pass);
    
         //fill your code
      ArrayList<Team> teamList = new ArrayList<Team>();
      
      String query = "select name, coach, home_city_id from team order by name";
      
      Statement st = con.createStatement();
      
      ResultSet rs = st.executeQuery(query);
      
      
      
      while(rs.next()){
    	  
    	  CityDAO role = new CityDAO();
    	  City c = role.getCityByID((long)rs.getInt(3));
    	  teamList.add(new Team(rs.getString(1), rs.getString(2), c));

      }
    	 
      return teamList;

  }
  
  
}
