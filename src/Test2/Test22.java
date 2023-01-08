package Test2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Test22 {

	static int N;
	static int[][] person;
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		N = in.nextInt();
		person = new int[N][2];
		
		for(int i=0;i<N;i++){
			person[i][0] = i;
			person[i][1] = in.nextInt();
		}
		
		Arrays.sort(person,new Comparator<int[]>(){
			public int compare(int[] p1, int[] p2){
				
				if(p1[1] == p2[1]){
					return Integer.compare(p1[0], p2[0]);
				}
				return Integer.compare(p1[1],p2[1]);
			}
		});
		
		int sum =0;
		int[] time = new int[N];
		for(int i=0;i<N;i++){
			sum +=person[i][1];
			time[i] = sum;
		}
		
		int total = 0;
		for(int i=0;i<N;i++){
			total += time[i];
		}
		System.out.println(total);
	}
}
