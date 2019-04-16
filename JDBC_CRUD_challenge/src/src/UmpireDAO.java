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


public class UmpireDAO {

  public List<Umpire> listAllUmpires() throws ClassNotFoundException, SQLException{
       ResourceBundle rb= ResourceBundle.getBundle("mysql");
      
      String url=rb.getString("db.url");
      String user=rb.getString("db.username");
      String pass=rb.getString("db.password");
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection(url,user,pass);
      List<Umpire> umpireList = new ArrayList<Umpire>();
   

      //fill your code
      String sql = "select * from umpire order by name";
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sql);
      
      while(rs.next()){
    	  
    	  long umpireId = rs.getLong(1);
    	  String umpireName = rs.getString(2);
    	  
    	  umpireList.add(new Umpire(umpireId, umpireName));
      }
      
      return umpireList;
    		  
  }
  
}
