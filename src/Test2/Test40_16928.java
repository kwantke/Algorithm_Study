package Test2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test40_16928 {

	static int L,S;
	static int[] goArr;
	static int[] count;
	static boolean[] visited;
	static Queue que;
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		L = in.nextInt();
		S = in.nextInt();
		goArr = new int[101];
		count = new int[101];
		visited = new boolean[101];
		for(int i=0;i<L+S;i++){
			goArr[in.nextInt()] = in.nextInt();
		}
		bfs();
	}
	public static void bfs(){
		que = new LinkedList();
		que.add(1);
	//	count[1] = 1;
		while(!que.isEmpty()){
			int mal = (int) que.remove();
			visited[mal] = true;
			
			if(mal == 100){
				System.out.println(count[mal]);
				return;
			}
			
			for(int i=1;i<7;i++){
				int move = i + mal;
				if(100 < move) continue;
				if(visited[move]) continue;
				
				visited[move] = true;
				if(goArr[move] != 0){
					int moveP = goArr[move];
					que.add(moveP);
					visited[moveP] = true;
					count[moveP] = count[mal] + 1;
				}
				else {
					que.add(move);
					count[move] = count[mal] + 1;
				}
			}
			
		}
	}
}
