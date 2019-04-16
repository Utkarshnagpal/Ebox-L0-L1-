




public class Skill {
	
	Long skillId;
	String skillName;
	
	public Skill()
	{}
	
	public Skill(Long skillId,String skillName)
	{
		this.skillId=skillId;
		this.skillName=skillName;		
	}
	
	public String getSkillName()
	{
		return skillName;
	}
	public void setSkillName(String skillName)
	{
		this.skillName=skillName;
	}


	public void setSkillId(Long skillId)
	{
		this.skillId=skillId;
	}
	public Long getSkillId()
	{
		return skillId;
	}





}
