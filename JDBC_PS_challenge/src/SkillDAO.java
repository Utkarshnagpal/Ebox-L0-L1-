



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;




public class SkillDAO{
	
public Skill getSkillByID(Long id) throws ClassNotFoundException, SQLException {
    ResourceBundle rb= ResourceBundle.getBundle("mysql");
    
    String url=rb.getString("db.url");
    String user=rb.getString("db.username");
    String pass=rb.getString("db.password");
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection(url,user,pass);
 
     //fill your code
    String sql = "select name from skill where id=?";
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setLong(1, id);
    ResultSet rs = pst.executeQuery();
    rs.next();
    return new Skill(id, rs.getString(1));

}


public Skill getSkillByName(String name) throws ClassNotFoundException, SQLException {
    ResourceBundle rb= ResourceBundle.getBundle("mysql");
    
    String url=rb.getString("db.url");
    String user=rb.getString("db.username");
    String pass=rb.getString("db.password");
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection(url,user,pass);


     //fill your code

    String sql = "select id from skill where name=?";
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setString(1, name);
    ResultSet rs = pst.executeQuery();
    rs.next();
    return new Skill(rs.getLong(1), name);
}

}
