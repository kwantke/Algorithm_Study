package Test2;

public class Test43_kakao2 {
	
	static char[] friend = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
	//static char[] friend = {'A', 'B', 'C'};
	static boolean[] checked;
	static int answer;
	public static void main(String[] args){
		
		String[] data = {"N~F=0", "R~T>2"};
		System.out.println(solution(8,data));
	}
	public static int solution(int n, String[] data) {
		checked = new boolean[friend.length];
		StringBuffer sb = new StringBuffer();
		dfs(sb,0,data);
		return answer;
	}
	
	public static void dfs(StringBuffer sb, int idx, String[] data){
		
		if(idx == friend.length){
			System.out.println(sb.toString());
			if(checkDistance(sb, data)){
				answer++;
			}
			return;
		}
		for(int i=0;i<friend.length;i++){
			
			if(checked[i]) continue;
			checked[i]=true;
			sb.append(String.valueOf(friend[i]));
			dfs(sb, idx+1,data);
			checked[i]=false;
			sb.delete(idx, sb.toString().length());
		}
	}
	public static boolean checkDistance(StringBuffer sb, String[] data){
		
		for(int i=0;i<data.length;i++){
			
			String ch = data[i];
			char cmp = ch.charAt(3);
			int gap = ch.charAt(4) - '0';
			int realGap = Math.abs(sb.toString().indexOf(ch.charAt(0))-sb.toString().indexOf(ch.charAt(2))) - 1;
			
			switch(cmp){
			case '<':
				if(realGap>= gap){
					return false;
				}break;
			case '>':
				if(realGap <= gap){
					return false;
				}break;
			case '=':
				if(realGap != gap){
					return false;
				}break;
			}
		}
		
		return true;
	}
}
