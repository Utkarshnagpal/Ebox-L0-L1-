public class Player {

	Long playerId;
	String playerName;
	Skill skill;
	
	
	public Player() 
	{}
	
	public Player(Long playerId,String playerName,Skill skill)
	{
		this.playerId=playerId;
		this.playerName=playerName;
		this.skill=skill;		
	}
	
	public Long getPlayerId()
	{
		return playerId;
	}
	
	public void setPlayerId(Long playerId)
	{
		this.playerId=playerId;
	}
	
	public String getPlayerName()
	{
		return playerName;
	}
	
	public void setPlayerName(String playerName)
	{
		this.playerName=playerName;
	}
	
	public Skill getSkill()
	{
		return skill;
	}
	
	public void setSkill(Skill skill)
	{
		this.skill=skill;
	}
	
}
