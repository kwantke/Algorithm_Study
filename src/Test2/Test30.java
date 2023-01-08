package Test2;

import java.util.Arrays;
import java.util.Scanner;

public class Test30 {
	
	static int N;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		N = in.nextInt();
		Integer[] arr = new Integer[N];
		for(int i=0;i<N;i++){
			arr[i]=in.nextInt();
		}
		Arrays.sort(arr);
		int M = in.nextInt();
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<M;i++){
			int key = in.nextInt();
			sb.append(upperBinary(arr, key) - lowerBinary(arr, key)).append(" ");
			
		}
		System.out.println(sb.toString());
	}
	
	public static int lowerBinary(Integer[] ar, int key){
		
		int low = 0;
		int high = ar.length;
		
		while(low<high) {
			int mid = (low+high)/2;
			
			if(key<=ar[mid]){
				high = mid;
			}
			else {
				low = mid+1;
			}
		}
		return low;
	}
	
	public static int upperBinary(Integer[] ar, int key){
		
		int low = 0;
		int high = ar.length;
		
		while(low < high) {
			int mid = (low+high)/2;
			
			if(key<ar[mid]){
				high = mid;
			}
			else {
				low = mid+1;
			}
		}
		return low;
		
	}
}
