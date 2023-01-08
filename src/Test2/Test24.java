package Test2;

import java.util.Scanner;

public class Test24 {
	
	static int N;
	static int size;
	static String str;
	static Integer[] stack;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		N = in.nextInt();
		stack = new Integer[N];
		size = 0;
		for(int i = 0;i<N;i++){
			str = in.next();
			
			switch(str) {
				case "push" :
					push(in.nextInt());
					break;
				case "pop" :
					System.out.println(pop());
					break;
				case "top" :
					System.out.println(top());
					break;
				case "size" :
					System.out.println(size());
					break;
				case "empty" :
					System.out.println(empty());
					break;
			}
		}
		
	}
	public static void push(int a){
		stack[size] = a;
		size++;		
	}
	public static int top(){
		if(size == 0)
			return -1;
		if(stack[size-1] == null)
			return -1;
		return stack[size-1];
	}
	public static int size(){
		return size;
	}
	public static int empty(){
		if(size == 0)
			return 1;
		if(stack[size-1] == null){
			return 1;
		}
		return 0;
	}
	public static int pop(){
		
		if(size == 0){
			return -1;
		}
		Integer a = stack[size-1];
		
		if(a == null){
			return -1;
		} else {
			stack[size-1] = null;
			size--;
			return a;
		}
	}
}
