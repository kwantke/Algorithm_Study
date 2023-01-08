package Test2;

import java.util.Scanner;

import java.util.Scanner;

public class Test33 {
	
	static int N;
	static int[][] arr;
	static boolean[][] visited;
	static int appart=0;
	static int[] result;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		N = in.nextInt();
		arr = new int[N][N];
		visited = new boolean[N][N];
		result = new int[100];
		for(int i=0;i<N;i++){
			String st = in.next();
			for(int t=0;t<N;t++){
				arr[i][t] = st.charAt(t) - '0';
			}
		}
		
		for(int i=0;i<N;i++){
			for(int t=0;t<N;t++){
				if(arr[i][t] == 1 && visited[i][t] == false){
					appart++;
					dfs(i,t);
				}
			}
		}
		System.out.println(appart);
		for(int i=1;i<appart+1;i++){
			System.out.println(result[i]);
		}
	}
	
	public static void dfs(int y, int x){
		result[appart]++;
		visited[y][x] = true;
		for(int i=0;i<4;i++){
			int nx = x + dx[i];
			int ny = y + dy[i];
			if( nx>=0 && ny>=0 && nx<N && ny<N) {
				if(arr[ny][nx] == 1 && !visited[ny][nx]){
					dfs(ny, nx);
				}
			}
			
		}
		
	}
}
