package Test2;

import java.util.Scanner;

public class Test17 {

	static int N,i;
	static int count=0;
	static int[] countArr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		N = in.nextInt();
		countArr = new int[100];
		if(N>1){
			
			cal(N,0);			
		}
		int min = countArr[0];
		for(int t=1;t<i;t++){
			if(min>countArr[t]){
				min = countArr[t];
			}
		}			
		System.out.println(min);
	}
	
	public static void cal(int N, int count){
		
		if(N == 1){
			countArr[i]=count;
			i++;
		}
		else {
			if(N%3==0){
				cal(N/3,count+1);
			} 
			if(N%2==0){
				cal(N/2,count+1);
			}
			cal(N-1,count+1);
		}
		
	}

}
