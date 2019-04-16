package src;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;


public class Main {
    
    public static void main(String ags[])throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("List of all Umpires"); 
        List<Umpire> umpireList = null;
        UmpireDAO umpireIns = new UmpireDAO();
    
        //fill your code  
        
        umpireList = umpireIns.listAllUmpires();
        
        int length = umpireList.size();
        
        for(int i = 0; i < length; i++){
        	System.out.println((i+1) + ")"+ umpireList.get(i).getUmpireName());
        }

    }
}
