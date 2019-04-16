


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class CityDAO {
  
  public City getCityByName(String name) throws ClassNotFoundException, SQLException {
      ResourceBundle rb= ResourceBundle.getBundle("mysql");
      
      String url=rb.getString("db.url");
      String user=rb.getString("db.username");
      String pass=rb.getString("db.password");
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection(url,user,pass);
     
      
      //fill your code
      String query = "select id from city where name=?";
    		  
      PreparedStatement st = con.prepareStatement(query);
      st.setString(1, name);
      ResultSet rs = st.executeQuery();
      rs.next();
      long CId = (long)rs.getInt(1);
      
      return new City(CId, name);
      	

  }
  
    public City getCityByID(Long id) throws ClassNotFoundException, SQLException {
      ResourceBundle rb= ResourceBundle.getBundle("mysql");
      
      String url=rb.getString("db.url");
      String user=rb.getString("db.username");
      String pass=rb.getString("db.password");
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection(url,user,pass);
     
     //fill your code
      String query = "select name from city where id=?";
	 
      PreparedStatement st = con.prepareStatement(query);
      
      st.setFloat(1, id);
      
      ResultSet rs = st.executeQuery();
      rs.next();
      String cityName = rs.getString(1);
      
      return new City(id, cityName);
  }
}
