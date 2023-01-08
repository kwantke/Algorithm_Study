package Test2;

import java.util.Scanner;

public class Test25 {
	
	static int N;
	static int[][] rec;
	static int w,b;
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		N = in.nextInt();
		rec = new int[N][N];
		w = b = 0;
		for(int i=0;i<N;i++){
			for(int t=0;t<N;t++){
				rec[i][t] = in.nextInt();
			}
		}
		res(0,0,N);
		System.out.println(w);
		System.out.println(b);
	}
	
	public static void res(int x, int y, int N) {
		if(cal(x,y,N)==true){
			if(rec[x][y]==0){
				w++;
			} else {
				b++;
			}
			return;
		} 
			int newSize = N/2;					
			res(x, y, newSize);			
			res(x, y+newSize, newSize);			
			res(x+newSize, y, newSize);
			res(x+newSize, y+newSize, newSize);
		
	}
	public static boolean cal(int x, int y, int N) {
		int tmp = rec[x][y];
		for(int i=x;i<x+N;i++){
			for(int t=y;t<y+N;t++){
				if(rec[i][t] != tmp)
					return false;
			}
		}
		return true;
	}
}
