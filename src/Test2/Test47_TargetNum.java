package Test2;

import java.util.Queue;

public class Test47_TargetNum {
	
	static int count;
	public static void main(String[] args){
	 //int[] numbers = {1, 1, 1,1,1};
	 int[] numbers = {1,2,3};
		int target = 3;
		System.out.println(solution(numbers, target));
	}
	static int solution(int[] numbers, int target) {
        int answer = 0;
        count =0;
        StringBuffer sb = new StringBuffer();       
        int sum=0;
        int sum2=0;
        for(int i=0;i<numbers.length;i++){
        	sum2+= numbers[i];
        }
        dfs(numbers,sb,target,0,0,0,sum2);
        return count;
    }
	
	public static void dfs(int[] numbers,StringBuffer sb, int target, int idx, int cnt, int sum,int sum2){
		if(cnt == numbers.length){ 
			return;
		}
		for(int i=idx;i<numbers.length;i++){
			sum += numbers[i];
			sb.append(numbers[i]);
			System.out.println(sb.toString());
			dfs(numbers,sb, target,i+1, cnt+1,sum,sum2);
			
			if(sum2-(sum*2) == target){
				count++;
			}			
			sum = sum - numbers[i];
			sb.delete(cnt, cnt+1);			
		}
	}
	
	public static void dfs2(String str,StringBuffer sb, int idx, int cnt){
		
		if(cnt == str.length()) return;
		
		for(int i = idx;i<str.length();i++){
			sb.append(str.charAt(i));
			dfs2(str,sb,idx+1,cnt+1);
			sb.delete(cnt, cnt+1);
		}
	}
	public static Queue que;
	public static int bfs(){
		
		return 1;
	}
}

/*
numbers	target	return
[1, 1, 1, 1, 1]	3	5
[4, 1, 2, 1]	4	2
*/
