package Test2;

import java.util.Scanner;

public class Test32 {
	
	static int N;
	static int[][] arr;
	static boolean[] checked;
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		N = in.nextInt();
		arr = new int[N][N];
		checked = new boolean[N];
		for(int i=0;i<N;i++){
			for(int t=0;t<N;t++){
				arr[i][t] = in.nextInt();
			}
		}
		
		dfs(0);
		
	}
	static void dfs(int x){
		
		//checked[x]= true;
	
		for(int t=0;t<N;t++){
			if(arr[x][t] == 1 ){
				checked[t] = true;
				System.out.println(arr[x][t]);
				dfs(t+1);
			}
		}
	}
}
