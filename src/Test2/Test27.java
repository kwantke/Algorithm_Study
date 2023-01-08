package Test2;

import java.util.Scanner;

public class Test27 {
	
	static int MOD=1000;
	static int N;
	static long B;
	static int[][] arr;
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		B = in.nextLong();
		arr = new int[N][N];
		
		for(int i=0;i<N;i++){
			for(int t=0;t<N;t++){
				arr[i][t] = in.nextInt();
			}
		}
		
		int[][] result = pow(arr,B);
		
		for(int i=0;i<N;i++){
			for(int t=0;t<N;t++){
				System.out.print(result[i][t]+" ");
			}
			System.out.println();
		}
	}
	
	public static int[][] pow(int[][] A, long exp){
		
		if(exp == 1L){
			return A;
		}
		
		int[][] ret = pow(A,exp/2);
		
		ret = multiply(ret,ret);
		
		if(exp%2 == 1){
			ret = multiply(ret, arr);
		}
		
		return ret;
	}
	
	public static int[][] multiply(int[][] arr1, int[][] arr2){
		
		int[][] mul = new int[N][N];
		
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				int sum = 0;
				for(int t=0;t<N;t++){
					mul[i][j] += arr1[i][t]*arr2[t][j];
					mul[i][j] = mul[i][j]%MOD; 
				}
			}
		}
		return mul;
	}
}
