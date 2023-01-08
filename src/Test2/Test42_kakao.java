package Test2;

import java.util.HashMap;
import java.util.Scanner;

public class Test42_kakao {
	
	static char[] friend = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
	static boolean[] checked;
	static int answer=0;
	static HashMap<String, Integer> rep;
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		String[] get = {"N~F=0", "R~T>2"};
		//String[] get = {"M~C<2", "C~M>1"};
		System.out.println(solution(8, get));
	}
	public static int solution(int n, String[] data) {
		checked = new boolean[8];
        StringBuffer sb = new StringBuffer();
        rep = new HashMap<String, Integer>();
        dfs(0,sb,data);
        return answer;
    }
	public static void dfs(int idx, StringBuffer sb, String[] data){
		if(idx == friend.length){
			if(isPassible(sb,data)){
				answer++;
			}
			return;
		}
		for(int i=0;i<friend.length;i++){
			
			if(checked[i]) continue;
			
			checked[i] = true;
			sb.append(String.valueOf(friend[i]));
			dfs(idx+1,sb, data);
			checked[i] = false;
			sb.delete(idx,friend.length);
		}
	}
	public static boolean isPassible(StringBuffer sb, String[] data){
		
			for(int i=0;i<data.length;i++){
				String con = data[i];			
				int gap = con.charAt(4) - '0';
				int realGap = Math.abs(sb.toString().indexOf(con.charAt(0)) - sb.toString().indexOf(con.charAt(2)))-1;
				
				switch(con.charAt(3)) {
				
					case '<' :
						if(realGap>=gap){
							return false;
						} break;
					case '>' :
						if(realGap<=gap){
							return false;
						}break;
					case '=' :
						if(realGap != gap){
							return false;
						}break;
				}
			}
			return true;
	}
	
}
