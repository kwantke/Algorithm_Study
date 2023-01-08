package Test2;

import java.util.Scanner;

public class Test07 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr;
		int[] dp;
		Scanner in =new Scanner(System.in);
		
		int N = in.nextInt();
		arr = new int[N+1];
		dp = new int[N+1];
		int[] dpDt = new int[N+1];
		arr[0] = 0;
		dp[1] = 1;
		for(int i=1;i<=N;i++){
			arr[i] = in.nextInt();
			
		}
		int temp = arr[1];
		int t = 1;
		for(int i=2;i<=N;i++){
			
			if(arr[i]>temp){
				temp = arr[i];
				t++;
				dpDt[t] = temp;
				dp[t]=t;
				
			} 
		}
		System.out.println(dp[t]);
		System.out.println();
		for(int a:dpDt){
			System.out.print(a+" ");
		}
	}
}
/*
가장 긴 증가하는 부분 수열
문제
수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.

예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.

입력
첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.

둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)

출력
첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.

예제 입력 1 
6
10 20 10 30 20 50
예제 출력 1 
4
*/
