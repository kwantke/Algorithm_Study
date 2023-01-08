package Test2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test37_7569 {
	static int H,M,N;
	static int[][][] board;
	static Queue que;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		M = in.nextInt();
		N = in.nextInt();
		H = in.nextInt();
		board = new int[H][N][M];
		que = new LinkedList<Tomato2>();
		for(int z=0;z<H;z++){
			for(int y=0;y<N;y++){
				for(int x=0;x<M;x++){
					int tmt = in.nextInt();
					board[z][y][x] = tmt;
					if(tmt == 1){
						que.add(new Tomato2(z,y,x));
					}
				}
			}
		}
		System.out.println(bfs());
	}
	
	public static int bfs(){
		int[] dx = {0,0,0,0,1,-1};
		int[] dy = {0,0,1,-1,0,0};
		int[] dz = {1,-1,0,0,0,0};
		
		while(!que.isEmpty()){
			Tomato2 tmt = (Tomato2)que.remove();
			int z = tmt.z;
			int y = tmt.y;
			int x = tmt.x;
			for(int i=0;i<6;i++){
				int nz = z+dz[i];
				int ny = y+dy[i];
				int nx = x+dx[i];
				if(nz>=0 && ny>=0 && nx>=0 && nz<H && ny<N && nx<M){
					if(board[nz][ny][nx] == 0){
						board[nz][ny][nx] = board[z][y][x] + 1; 
						que.add(new Tomato2(nz,ny,nx));
					}
				}
			}
		}
		int result = Integer.MIN_VALUE;
		for(int az=0;az<H;az++){
			for(int ay=0;ay<N;ay++){
				for(int ax=0;ax<M;ax++){
					int days = board[az][ay][ax];
					if(days == 0)
						return -1;
					else {
						result = Integer.max(result, days);
					}
				}
			}
		}
		if(result == 1)
			return 0;
		return result-1;
	}
}
class Tomato2 {
	int z;
	int y;
	int x;
	Tomato2(){}
	Tomato2(int z, int y, int x) {
		this.z=z;
		this.y=y;
		this.x=x;
	}

}
