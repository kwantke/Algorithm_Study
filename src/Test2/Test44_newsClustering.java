package Test2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test44_newsClustering {
	
	public static void main(String[] args){
			
		String str1 = "";
		String str2 = ""; 
		
		System.out.println(solution(str1.toLowerCase(), str2.toLowerCase()));
		//System.out.println(solution("handshake".toLowerCase(), "shake hands".toLowerCase()));
		//System.out.println(solution("aa1+aa2".toLowerCase(), "AAAA12".toLowerCase()));
		//System.out.println(solution("E=M*C^2".toLowerCase(), "e=m*c^2".toLowerCase()));
	}
	
	 static int solution(String str1, String str2) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        int stInt = str1.length();
        int stInt2 = str2.length();
        int all =  0;
        int con =  0;
        for(int i=0;i<=str1.length()-2;i++){
        	String st = str1.substring(i,i+2);
        	if(!specialCheck(st)){
        		map.put(st, map.getOrDefault(st,0)+1);
            	all++;
        	}
        }
        
        for(int i=0;i<=str2.length()-2;i++){
        	String str = str2.substring(i,i+2);
        	if(specialCheck(str)) continue;
        	if(map.containsKey(str) && map.get(str)>=1){
        		map.put(str,map.getOrDefault(str,0)-1);        		
        		con++;
        		continue;
        	}
        	all++;
        }
        if(con == 0 || all == 0){
        	return 65536;
        }
                       	
        answer =(int)((float)con/all*65536);
               
        return answer;
    }
	 
	static boolean specialCheck(String str){
		boolean ch = false;
		if(!str.matches("^[a-zA-Z]*$")){
			ch = true;
		}
		return ch;
	}
}
