package Test2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test39_7562 {
	
	static int N,S;
	static int[][] arr;
	static int[][] visited;
	static Queue<Point> que;
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		while(N-->0){
			
			S = in.nextInt();
			arr = new int[S][S];
			visited = new int[S][S];
			
			int x1 = in.nextInt();
			int y1 = in.nextInt();
			int x2 = in.nextInt();
			int y2 = in.nextInt();
			
			resetVisit();
			
			visited[y1][x1]=0;
			dfs(y1,x1,y2,x2);
			for(int i=0;i<S;i++){
				for(int t=0;t<S;t++){
					System.out.print(visited[i][t]+" ");
				}
				System.out.println();
			}
			System.out.println(visited[y2][x2]);
		}
		
	}
	public static void dfs(int y1,int x1,int y2,int x2 ){
		Queue<Point> que = new LinkedList<>();
		que.add(new Point(y1, x1));
		int[] dy = {-2,-1,2,1,2,1,-1,-2};
		int[] dx = {-1,-2,-1,-2,1,2,2,1};

		while(!que.isEmpty()){
			Point p = que.remove();
			
			if(p.x == x2 && p.y==y2){
				break;
			}
			for(int i=0;i<8;i++){
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(nx>=0 && ny >=0 && nx<S && ny<S){
					if(visited[ny][nx] == -1){
						visited[ny][nx] = visited[p.y][p.x]+1;
						que.add(new Point(ny,nx));
					}
				}
			}
			
		}
	}
	public static void resetVisit(){
		for(int i=0;i<S;i++){
			for(int t=0;t<S;t++){
				visited[i][t]=-1;
			}
		}
	}
}
class Point {
	int x;
	int y;
	Point(){}
	Point(int y, int x){
		this.x = x;
		this.y = y;
	}
}
/*
체스판 위에 한 나이트가 놓여져 있다. 나이트가 한 번에 이동할 수 있는 칸은 아래 그림에 나와있다. 나이트가 이동하려고 하는 칸이 주어진다. 나이트는 몇 번 움직이면 이 칸으로 이동할 수 있을까?



입력
입력의 첫째 줄에는 테스트 케이스의 개수가 주어진다.

각 테스트 케이스는 세 줄로 이루어져 있다. 첫째 줄에는 체스판의 한 변의 길이 l(4 ≤ l ≤ 300)이 주어진다. 체스판의 크기는 l × l이다. 체스판의 각 칸은 두 수의 쌍 {0, ..., l-1} × {0, ..., l-1}로 나타낼 수 있다. 둘째 줄과 셋째 줄에는 나이트가 현재 있는 칸, 나이트가 이동하려고 하는 칸이 주어진다.

출력
각 테스트 케이스마다 나이트가 최소 몇 번만에 이동할 수 있는지 출력한다.

예제 입력 1 
3
8
0 0
7 0
100
0 0
30 50
10
1 1
1 1
예제 출력 1 
5
28
0
*/
