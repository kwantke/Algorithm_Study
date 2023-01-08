package Test2;

import java.util.Arrays;


public class Test55_Checking {
	
	// 방문처리에 사용 할 배열선언
		static boolean[] vistied = new boolean[9];
		
		// 그림예시 그래프의 연결상태를 2차원 배열로 표현
		// 인덱스가 각각의 노드번호가 될 수 있게 0번인덱스는 아무것도 없는 상태라고 생각하시면됩니다.
		//static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
		static int[][] graph = {{},{2,3},{3,4},{4},{},{1}};
		static int[][] res = new int[6][6];
		static int max = Integer.MAX_VALUE;
		public static void main(String[] args) {
			
			res[5][1]=1 ;
			res[1][2]=2 ;
			res[1][3]=3 ;
			res[2][3]=4 ;
			res[2][4]=5 ;
			res[3][4]=6 ;

			for(int i=1;i<=5;i++){
				max = Integer.MAX_VALUE;
				dfs(1,i,0);
				if(max == Integer.MAX_VALUE){
					System.out.println("INF");
				}else 
					System.out.println(max);
			}
		}
		public static void dfs(int nodeIndex,int idx,int resl){
			if(nodeIndex == idx){
				max = Math.min(max, resl);
				return;
			}
			for(int i: graph[nodeIndex]){
				resl += res[nodeIndex][i];
				dfs(i,idx,resl);
				if(i == idx){
					
				}
				resl = resl - res[nodeIndex][i];
			}
		}
		
		/*static void dfs(int nodeIndex) {
			// 방문 처리
			vistied[nodeIndex] = true;
			
			// 방문 노드 출력
			System.out.print(nodeIndex + " -> ");
			
			// 방문한 노드에 인접한 노드 찾기
			for (int node : graph[nodeIndex]) {
				// 인접한 노드가 방문한 적이 없다면 DFS 수행
				if(!vistied[node]) {
					dfs(node);
				}
			}
		}*/
}
/*
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6
*/
