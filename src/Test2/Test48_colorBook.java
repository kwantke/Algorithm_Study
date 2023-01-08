package Test2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Test48_colorBook {
	
	static boolean[][] checked;
	static int[] idx = {0,1,-1,0};
	static int[] idy = {1,0,0,-1};
	static int N,M;
	static Map<Integer, Integer> map;
	public static void main(String[] args){
						 
		//int[][] picture = 
		/*
		{1, 1, 1, 0},
		{1, 2, 2, 0},
		{1, 0, 0, 1},
		{0, 0, 0, 1},
		{0, 0, 0, 3},
		{0, 0, 0, 3}};

*/

		int[][] picture = {{1, 1, 1, 0},{1, 1, 1, 0},{0, 0, 0, 1},{0, 0, 0, 1},{0, 0, 0, 1},{0, 0, 0, 1}};
		//[[1, 1, 1, 0], [1, 1, 1, 0], [0, 0, 0, 1], [0, 0, 0, 1], [0, 0, 0, 1], [0, 0, 0, 1]]
		int m = 6;
		int n = 4;
		int[] result = solution(m,n,picture);
		System.out.println(result[0]+", "+result[1]);
	}
	
	static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        checked = new boolean[m][n];
        
        M = m;
        N = n;
        int max =0;
        for(int i=0;i<m;i++){
        	for(int t=0;t<n;t++){
        		if(!checked[i][t]){        		
        			map = new HashMap<>();
        			dfs(i,t,picture);
        			if(picture[i][t] !=0){        				
        				Iterator<Integer> keys = map.keySet().iterator();
            			while( keys.hasNext() ){
            				Integer key = keys.next();
            				max = Math.max(map.get(key), max); 
            			}            			
            			numberOfArea++;
        			}
        		}
        	}
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = max;
        return answer;
    }
	static void dfs(int y, int x, int[][] pictures){
		checked[y][x] = true;
		if(pictures[y][x]!=0){
			map.put(pictures[y][x],map.getOrDefault(pictures[y][x], 0)+1);
			for(int i=0;i<4;i++){
				int ny = y + idy[i];
				int nx = x + idx[i];			
				if(ny>=0 && nx>=0 && ny<M && nx<N){
					if(checked[ny][nx]) continue;
					if(pictures[ny][nx] == pictures[y][x])
						dfs(ny,nx,pictures);
				}
			}
		} /*else if(pictures[y][x] == 0){
			for(int i=0;i<4;i++){
				int ny = y + idy[i];
				int nx = x + idx[i];			
				if(ny>=0 && nx>=0 && ny<M && nx<N){
					if(checked[ny][nx]) continue;
					if(pictures[ny][nx] ==0&&pictures[y][x] == 0)
						dfs(ny,nx,pictures);
				}
			}
		}*/
	}
}

/*
m	n	picture	answer
6	4	[[1, 1, 1, 0],
         [1, 2, 2, 0],
         [1, 0, 0, 1],
         [0, 0, 0, 1],
         [0, 0, 0, 3],
         [0, 0, 0, 3]]	[4, 5]
*/