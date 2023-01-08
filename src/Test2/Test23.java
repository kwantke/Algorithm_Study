package Test2;

import java.util.Scanner;

public class Test23 {

	static int N;
	static int  W;
	static int[] thing;
	static int[] value;
	static int num;
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		N = in.nextInt();
		W = in.nextInt();
		thing = new int[N];
		value = new int[N];
		for(int i=0;i<N;i++){
			thing[i] = in.nextInt();
			value[i] = in.nextInt();
		}
		
		for(int i=0;i<N;i++){
			res(i);
		}
		System.out.println(num);
	}
	
	public static void res(int N){
		
		int sum = 0;
		int vSum = 0;
		for(int i=N;i>=0;i--){
			sum += thing[i];
			if(sum > W){
				sum = sum - thing[i];
			} else {
				vSum+=value[i];
			}
		}
		if(vSum>num){
			num = vSum;
		}
	}
	
}
