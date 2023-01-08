package Test2;

import java.util.Scanner;

public class Test36_1697 {
	static int N1,N2;
	static int count=0;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		N1 = in.nextInt();
		N2 = in.nextInt();
		
		dfs(N1);
		System.out.println(count);
	}
	public static void dfs(int n){
		
		if(n == N2)
			return;
		if(n>N2){
			count++;
			dfs(n-1);
		}else {
			int mul = 2*n;
			if(mul == N2) return;
			if(mul > N2){
				if(mul-1 == N2){
					count++;
					dfs(mul);
				} else if(mul-2 >= N2){
					count++;
					dfs(n-1);
				}
			}else {
				count++;
				dfs(mul);
			}
		}
	}
}
/*
숨바꼭질 
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	128 MB	155379	44195	27680	25.036%
문제
수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.

수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

입력
첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.

출력
수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.

예제 입력 1 
5 17
예제 출력 1 
4
*/
