package Test2;

import java.util.ArrayList;
import java.util.Scanner;

public class Test18 {

	static char[] str1;
	static char[] str2;
	static int let;
	static ArrayList<Character> arr;
	static boolean[] check;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		str1 = in.next().toCharArray();
		str2 = in.next().toCharArray();
		int size = str1.length;
		arr = new ArrayList<Character>();
		check = new boolean[size];
		
		for(int i=0;i<size;i++){
			cal(i);
		}
		for(char a: arr){
			System.out.print(a);
		}
	}

	public static void cal(int N){
		
		for(int i=let;i<str2.length;i++){
			if(!check[i]){
				if(str1[N]==str2[i]){
					arr.add(str2[i]);
					check[i]=true;
					let=i+1;
					break;
				}
			}
		}
	}
}
