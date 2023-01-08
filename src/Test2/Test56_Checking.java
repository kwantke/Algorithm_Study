package Test2;

import java.util.Arrays;


public class Test56_Checking {
	
	public static void main(String[] args){
		
		String str = "ABC";
		char[] ch = str.toCharArray();
		Arrays.sort(ch);
		String newStr = String.valueOf(ch);
		String newStr2 = ch.toString();
		System.out.println(solution(ch.length,newStr));
		
		
	}
	static boolean[] checked;
	public static int solution(int n, String str){
	
		StringBuffer sb = new StringBuffer();
		
		//dfs(n,0,0,str.toCharArray(),sb);
		
		checked = new boolean[str.toCharArray().length];
		dfs2(n,0,sb,str.toCharArray());
		
		return 1;
		
	}
	public static void dfs2(int n, int idx, StringBuffer sb, char[] chArr){
		if(idx == n){
			System.out.println(sb.toString());
			return;
		}
		for(int i=0;i<chArr.length;i++){
			if(checked[i]) continue;
			checked[i]= true;
			sb.append(chArr[i]);
			dfs2(n,idx+1,sb, chArr);
			checked[i] = false;
			sb.delete(idx, chArr.toString().length()-1);
		}
	}
	
	public static void dfs(int n, int idx, int cnt,char[] chArr, StringBuffer sb){
		
		if(cnt == n){
			//System.out.println(sb.toString());
			return;
		}
		for(int i=idx;i<chArr.length;i++){
			sb.append(chArr[i]);
			System.out.println(sb.toString());
			dfs(n,i+1,cnt+1,chArr, sb);
			sb.delete(cnt, cnt+1);
		}
	}
}

