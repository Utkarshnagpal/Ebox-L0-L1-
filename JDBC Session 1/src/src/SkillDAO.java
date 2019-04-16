package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class SkillDAO {

  public List<Skill> listAllSkills() throws ClassNotFoundException, SQLException{
       ResourceBundle rb= ResourceBundle.getBundle("mysql");
      
      String url=rb.getString("db.url");
      String user=rb.getString("db.username");
      String pass=rb.getString("db.password");
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection(url,user,pass);
   
      //fill your code
      PreparedStatement ps = con.prepareStatement("select * from skill order by name");
      
      ResultSet rs = ps.executeQuery();
      
      ArrayList<Skill> skillList = new ArrayList<Skill>();
      
      while(rs.next()){
    	  long id = (long) rs.getInt(1);
    	  String skillName = rs.getString(2);
    	  
    	  skillList.add(new Skill(id, skillName)); 
      }
      
      return skillList;
  }
  
}
