package Test2;
/*프로그래머스 - 등굣길 - JAVA*/
public class Test05 {

	public static void main(String[] args) {
		int[][] puddles ={{2,2}};
		System.out.println(solution(4,3,puddles));
	}
	
	public static int solution(int m, int n, int[][] puddles) {
		int answer = 0;
		boolean [][] isPuddles = new boolean[n][m];
		int[][] map = new int[n][m];
		for(int[] pud : puddles){
			isPuddles[pud[1]-1][pud[0]-1]= true;
		}
		
		boolean flag = false;
		for(int i=1;i<m;i++){
			if(isPuddles[0][i]){
				flag = true;
			}
			if(!flag)
				map[0][i]=1;
		}
		
		flag = false;
		for(int i=1;i<n;i++){
			
			if(isPuddles[i][0]){
				flag=true;				
			}
			if(!flag){
				map[i][0]=1;
			}
		}
		
		for(int i=1;i<n;i++){
			for(int t=1;t<m;t++){
				if(!isPuddles[i][t])
					map[i][t] = map[i][t-1] + map[i-1][t];
			}
		}
		
		return map[n-1][m-1];		
	}
}
