package Test2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Test21 {
	
	static int N;
	static int[][] meeting;
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		N = in.nextInt();
		meeting = new int[N][2];
		
		for(int i=0;i<N;i++){
			meeting[i][0] = in.nextInt();
			meeting[i][1] = in.nextInt();
		}
		
		Arrays.sort(meeting, new Comparator<int[]>(){
			public int compare(int[] c1,int[] c2){
				if(c1[1] == c2[1]){
					return Integer.compare(c1[0], c2[0]);
				}
				
				return Integer.compare(c1[1],c2[1]);
			}
		});
		
		int endT=0,count=0;
		
		for(int i=0;i<N;i++){
			System.out.println("start: "+meeting[i][0]+", end: "+meeting[i][1]);
			if(endT<=meeting[i][0]){
				endT = meeting[i][1];
				count++;
			}
			
			
		}
		System.out.println(count);
	}

}
