package Test2;

public class Test43_kakao2_1 {
	
	static char[] friend = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
	static boolean checked[];
	static String[] data = {"N~F=0", "R~T>2"};
	static int answer=0;
	public static void main(String[] args){
		
		//String[] data = {"N~F=0", "R~T>2"};
		System.out.println(solution(friend, data));
		//check("ABNDEF");
	}
	public static int solution(char[] frd,String[] data) {
		int answer=0;
		StringBuffer sb = new StringBuffer();
		checked = new boolean[frd.length];
		dfs(sb,0);
		return answer;
	}
	public static void dfs(StringBuffer sb,int idx){
		
		if(idx == friend.length){
			System.out.println(sb.toString());
			if(check(sb.toString())) answer++;
			
			return;
		}
		
		for(int i=0;i<friend.length;i++){
			
			if(checked[i]) continue;
			checked[i] = true;
			sb.append(friend[i]);
			dfs(sb, idx+1);
			checked[i]=false;
			sb.delete(idx, sb.toString().length());
		}
	}
	public static boolean check(String sb){
		
		for(int i=0;i<data.length;i++){
			String da = data[i];
			char alph = da.charAt(3);
			int gap = da.charAt(4) - '0';
			int realGap = Math.abs(sb.indexOf(da.charAt(0)) - sb.indexOf(da.charAt(2))) - 1;
			//System.out.println("realGap= "+realGap);
			
			switch(alph){
				case '<':
					if(realGap<=gap) return true; 
					break;
				case '>':
					if(realGap>=gap) return true;
					break;
				case '=':
					if(realGap==gap) return true;
					break;			
			}
		}
		
		return false;
	}
	

	
}
