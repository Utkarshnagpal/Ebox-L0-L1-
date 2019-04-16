

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import src.Skill;
import src.SkillDAO;


public class Main {
    
    public static void main(String ags[])throws Exception{
       
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("List of all skills"); 
        List<Skill> skillList = null;
        SkillDAO skillIns = new SkillDAO();
 
  
        //fill code here
       skillList = skillIns.listAllSkills();

       
       int length = skillList.size();
       for(int i = 0; i < length; i++)
    	   System.out.println((i+1) + ") " + skillList.get(i));
       

      
        
    }
}
