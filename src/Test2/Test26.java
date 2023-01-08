package Test2;

import java.util.Scanner;


public class Test26 {
	static int N;
	static int C;
	static int[][] arr, result;
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);	
		
		N = in.nextInt();
		C = in.nextInt();
		arr = new int[N][N];
		
		result = new int[N][N];
		
		for(int i=0;i<N;i++){
			for(int t=0;t<N;t++){
				arr[i][t]=in.nextInt();
			}
		}
		result = arr;
		for(int t=0;t<C-1;t++){			
				mul(result);
		}		
		
		for(int i=0;i<N;i++){
			for(int t=0;t<N;t++){
				System.out.print(result[i][t]%1000+" ");
			}
			System.out.println();
		}
		
	}
	
	static void mul(int[][] result1){
		int tmp=0;
		int[][] sum = new int[N][N];
		
		
		for(int i=0;i<N;i++){
			for(int x=0;x<N;x++){
				tmp =0;
				for(int t=0;t<N;t++){
					tmp +=result1[i][t]*arr[t][x];
				}
				sum[i][x] = tmp;
				
			}		
		}
		result = sum;
		
	}
}
