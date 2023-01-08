package Test2;

import java.util.Scanner;

public class Test28 {
	static int N;
	static int M;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		N = in.nextInt();
		int[] origin = new int[N];
		for(int i=0;i<N;i++){
			origin[i]=in.nextInt();
		}
		M = in.nextInt();
		int[] sang = new int[M];
		for(int i=0;i<M;i++){
			sang[i]=in.nextInt();
		}
		
		boolean[] check = new boolean[N];
		int[] res = new int[M];
		int count=0;
		
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<M;i++){
			for(int t=0;t<N;t++){
				if(!check[t]){
					if(sang[i]==origin[t]){
						count++;
						check[t] = true;
					}
				}
			}
			res[i]=count;
			sb.append(count).append(" ");
			count = 0;
		}
		System.out.println(sb.toString());
		
	}
}
