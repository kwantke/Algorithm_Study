package Test2;

import java.util.Scanner;

public class Test19 {

	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		int result=1;;
		for(int i=N;i>0;i--){
			result =result*i;
		}
		System.out.println(result);
	}

}
