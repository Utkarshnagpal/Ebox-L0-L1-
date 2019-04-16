package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TeamDAO {
	 public Team getTeamByID(Long id) throws ClassNotFoundException, SQLException {
		 
	     ResourceBundle rb= ResourceBundle.getBundle("mysql");
	        
	     String url=rb.getString("db.url");
	     String user=rb.getString("db.username");
	     String pass=rb.getString("db.password");
	     Connection con = DriverManager.getConnection(url,user,pass);
	     

         //fill your code
	       
	     String sql = "select name from team where id="+id;
	     
	     Statement st = con.createStatement();
	     
	     ResultSet rs = st.executeQuery(sql);
	     rs.next();
	     
	     return new Team((long)id, rs.getString(1));
	     
   }
}
