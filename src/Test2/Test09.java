package Test2;

import java.util.Scanner;

public class Test09 {

	static int arr[];
	static Integer dp[];
	static int max;
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		arr = new int[N];
		dp = new Integer[N];
		for(int i=0;i<N;i++){
			arr[i] = in.nextInt();
		}
		dp[0] = arr[0];
		max = arr[0];
		test(N-1);
		System.out.println(max);
	}
	
	public static int test(int N){
		
		if(dp[N] == null){
			dp[N] = test(N-1) + arr[N];
			if(dp[N] == 7){
				System.out.print(arr[N]);
			}
			//dp[N]=Math.max(test(N-1)+arr[N], arr[N]);
			//max=Math.max(dp[N],max);
		}
		return dp[N];
	}
}
