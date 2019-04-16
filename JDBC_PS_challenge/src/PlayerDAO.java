


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;



public class PlayerDAO {

	

public List<Player> getAllPlayers() throws ClassNotFoundException, SQLException {

       List<Player> Al=new ArrayList<Player>();
       Player player=null;
      try
      {
             
          ResourceBundle rb= ResourceBundle.getBundle("mysql");
          
          String url=rb.getString("db.url");
          String user=rb.getString("db.username");
          String pass=rb.getString("db.password");
          Class.forName("com.mysql.jdbc.Driver");
          Connection con = DriverManager.getConnection(url,user,pass);
  
            //fill your code
          String sql = "select id, name, skill_id from player";
          Statement st = con.createStatement();
          ResultSet rs = st.executeQuery(sql);
          
          SkillDAO sd = new SkillDAO();
          
          while(rs.next()){
    		Long playerId = rs.getLong(1);
    		String playerName = rs.getString(2); 
    		long skillId = rs.getLong(3);
    		Skill skill = sd.getSkillByID(skillId);
    		player = new Player(playerId, playerName, skill);
    		Al.add(player);
          }
          
          return Al;
      }
      catch(Exception e){}

      return null;

  }
  
  public void updatePlayerDetails(Long playerId, String skill) throws ClassNotFoundException, SQLException {
    
	  ResourceBundle rb= ResourceBundle.getBundle("mysql");
      
      String url=rb.getString("db.url");
      String user=rb.getString("db.username");
      String pass=rb.getString("db.password");
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection(url,user,pass);


       //fill your code
      String sql = "update player set skill_id=? where id=?";
      PreparedStatement pst = con.prepareStatement(sql);

      SkillDAO sdao = new SkillDAO();
      Skill s = sdao.getSkillByName(skill);
      pst.setLong(1, s.getSkillId());
      pst.setLong(2, playerId);
      
      pst.executeUpdate();
   
      
  }
  public static void displayPlayers(List<Player> playerList){
      System.out.format("%-15s %-30s %-15s\n","Id","Name","Skill"); 

     //fill your code
      for(Player p :playerList)
    	 System.out.println(String.format("%-15s %-30s %-15s",p.getPlayerId(), p.getPlayerName(), p.getSkill().getSkillName()));
  }
	
	
}
