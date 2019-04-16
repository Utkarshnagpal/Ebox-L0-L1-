package src;



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


public List<Team> getAllTeams() throws ClassNotFoundException, SQLException {
      
       List<Team>Al=new ArrayList<Team>();
       //Team team=null;
      try
      {
  
          ResourceBundle rb= ResourceBundle.getBundle("mysql");
          
          String url=rb.getString("db.url");
          String user=rb.getString("db.username");
          String pass=rb.getString("db.password");
          Class.forName("com.mysql.jdbc.Driver");
          Connection con = DriverManager.getConnection(url,user,pass);

          //fill your code
          
          String sql = "select name, coach from team";
          
          Statement st = con.createStatement();
          ResultSet rs = st.executeQuery(sql);
          
          while(rs.next())
        	  Al.add(new Team(rs.getString(1), rs.getString(2)));
          
          return Al;
      }
      catch(Exception e){}
      
      return Al;
  }
  
  public void updateTeamDetails(String name,String coach) throws ClassNotFoundException, SQLException {
    
	  ResourceBundle rb= ResourceBundle.getBundle("mysql");
      
      String url=rb.getString("db.url");
      String user=rb.getString("db.username");
      String pass=rb.getString("db.password");
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection(url,user,pass);
      
        
      //fill your code
      String sql = "Update team set coach=? where name=?";
      PreparedStatement pst = con.prepareStatement(sql);
      
      //Set coach name to corresponding team name
      pst.setString(1, coach);
      pst.setString(2, name);
      
      //Update the table
      pst.executeUpdate();
     
  }
  
  
  public void displayTeams(List<Team> teamList){
      System.out.format("%-30s %-15s\n","Name","Coach"); 
    
       //fill your code
     for(Team t :teamList)
    	 System.out.format("%-30s %-15s\n", t.getTeamName(), t.getCoachName()); 
      

  }
  
}
