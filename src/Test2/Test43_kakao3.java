package Test2;

public class Test43_kakao3 {
	
	static char[] friend = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
	static boolean[] checked;
	static int count;
	public static void main(String[] args){
		
		String[] data = {"N~F=0", "R~T>2"};
		System.out.println(solution(2,data));
	}
	
	public static int solution(int n, String[] data) {
		int answer;
		StringBuffer sb = new StringBuffer();
		checked = new boolean[friend.length];
		dfs(sb,0,data);
		return count;
	}
	static void dfs(StringBuffer sb, int cnt, String[] data){
		
		if(cnt == friend.length){
			if(compare(sb, data)){
				count++;
			}
			return;
		}
		
		for(int i=0;i<friend.length;i++){
			if(checked[i]) continue;
			checked[i] = true;
			sb.append(friend[i]);
			dfs(sb,cnt+1,data);
			checked[i] = false;
			sb.delete(cnt, sb.toString().length());
		}
	}
	static boolean compare(StringBuffer sb, String[] data){
		
		for(int i=0;i<data.length;i++){
						
			int realGap = Math.abs(sb.toString().indexOf(data[i].charAt(0)) - sb.toString().indexOf(data[i].charAt(2))) - 1;
			int gap = data[i].charAt(4) - '0';
			switch(data[i].charAt(3)){
			case '<':
				if(realGap >= gap){
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
