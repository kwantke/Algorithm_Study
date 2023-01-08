package Test2;

import java.util.Scanner;

public class Test15 {

	static int N;
	static int max;
	static int[] seq;
	static Integer[] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		N = in.nextInt();
		seq = new int[N];
		dp = new Integer[N];
		
		for(int i=0;i<N;i++) {
			seq[i] = in.nextInt();
		}
		
		for(int i=0;i<N;i++){
			LIS(i);
		}
		int max = dp[0];
		for(int i=1;i<N;i++){
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
	public static int LIS(int N){
		
		int sum = 0;
		if(dp[N] == null){
			dp[N]=seq[N];
			for(int i=N-1;i>=0;i--){
				sum += seq[i]; 
				dp[N] = Math.max(dp[N],sum+seq[N]);
				
				max = Math.max(dp[N], LIS(i));
			}
		
		}
		return dp[N];
	}

}
