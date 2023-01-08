package Test2;

import java.util.Scanner;

public class Test13 {
	
	static int N;
	static int[] arr;
	static Integer[] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		
		N = in.nextInt();
		arr = new int[N+1];
		dp = new Integer[N+1];
		for(int i=1;i<=N;i++){
			arr[i] = in.nextInt();
		}
		dp[0]=arr[0];
		dp[1]=arr[1];
		if(N>2){
			dp[2]=Math.max(arr[0],arr[1])+arr[2];
		}
		System.out.println(find(N));
		
	}
	
	public static int find(int n){
		if(dp[n] == null){			
			dp[n] = Math.max(find(n-2), find(n-3)+arr[n-1])+arr[n];
		}
			
		return dp[n];
	}
}



/*N = in.nextInt();
arr = new int[N][2];

for(int i=0;i<N;i++){
	arr[i][0] = in.nextInt();
	arr[i][1] = in.nextInt();
}

for(int i=0;i<N;i++){
	for(int t=0;t<N;t++){
		int preStart = arr[i][0];
		int preLast = arr[i][1];
		if(t != i){
			int nextStart = arr[t][0];
			int nextLast = arr[t][1];
			
			if(nextStart>=preLast){
				preLast = nextStart;
			}else{
				if(nextLast<preLast)
			}
		}
	}
}*/