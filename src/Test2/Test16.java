package Test2;

import java.util.Scanner;

public class Test16 {
	static int N;
	static int[] seq;
	static Integer[] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		
		N = in.nextInt();
		seq = new int[N];
		dp = new Integer[N];
		for(int i=0;i<N;i++){
			seq[i]=in.nextInt();
		}
		dp[0] = seq[0];
		dp[1] = seq[0]+seq[1];
		if(N>2){
			dp[2] = Math.max(seq[0], seq[1])+seq[2];
		}
		int max = Math.max(res(N-2),res(N-1));
		System.out.println(max);
		
	}
	public static int res(int N){
		
		if(dp[N]==null){
			dp[N] = Math.max(res(N-3)+seq[N-1], res(N-2))+seq[N];
		}
		return dp[N];
	}

}
