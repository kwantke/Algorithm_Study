package Test2;

import java.util.Scanner;

public class Test14 {

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
			seq[i] = in.nextInt();
		}
		for(int i=0;i<N;i++){
			LIS(i);
		}
		
	}
	static int LIS(int N){
		
		if(dp[N] == null){
			dp[N]=1;
			for(int i=N-1;i>=0;i--){
				if(seq[i]<seq[N])
				dp[N]=Math.max(dp[N], LIS(i)+1);
			}
			
		}
		return dp[N];
	}

}
