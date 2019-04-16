package src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;


public class Main {
    
    public static void main(String ags[])throws Exception{
       
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("List of all skills"); 
        List<Skill> skillList = null;
        SkillDAO skillIns = new SkillDAO();
 
  
        //fill code here
       skillList = skillIns.listAllSkills();
       
       System.out.println("List of all skill");
       
       int length = skillList.size();
       for(int i = 0; i < length; i++)
    	   System.out.println((i+1) + ") " + skillList.get(i));
       

      
        
    }
}
