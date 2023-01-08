package Test2;

import java.util.Scanner;

public class Test38_7562 {
	static int N,R;
	static int Y,X;
	static int[][] arr;
	static boolean[][] checked;
	static int count=0, a=0;
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
				
		while(N-->0){
			R = in.nextInt();
			arr = new int[R][R];
			checked = new boolean[R][R];
			count=0;
			int x1=in.nextInt();
			int y1=in.nextInt();
			arr[y1][x1] = 0;
			int x2=in.nextInt();
			int y2=in.nextInt();
			arr[y2][x2] = 1;
			dfs(y1,x1);
		}
		
	}
	
	public static int dfs(int y, int x){
		
		int[] dy = {-2,-1,2,1,2,1,-1,-2};
		int[] dx = {-1,-2,-1,-2,1,2,2,1};		
		
		return 0;
	}
}
