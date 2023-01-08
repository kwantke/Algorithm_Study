package Test2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Test51 {

	static int N;
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		
		N = in.nextInt();
	
		int[][] meeting = new int[N][2]; 
		
		for(int i=0;i<N;i++){
			meeting[i][0] = in.nextInt();
			meeting[i][1] = in.nextInt();
		}
		System.out.println(result(meeting));
		
		
	}
	static int result(int[][] meeting){
		int count=0;
		
		Arrays.sort(meeting, new Comparator<int[]>(){
			@Override
			public int compare(int[] c1, int[] c2) {
				if(c1[1] == c2[1]){
					return Integer.compare(c1[0], c2[0]);
				}
				return Integer.compare(c1[1],c2[1]);
			}
		});
		
		int endT = 0;
		for(int i=0;i<N;i++){
			if(endT <= meeting[i][0]){
				endT = meeting[i][1];
				count++;
			}
		}
		return count;
	}
}
/*
회의실 배정
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	128 MB	130716	40481	28812	29.493%
문제
한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다. 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자. 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다. 회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.

입력
첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 시작 시간과 끝나는 시간은 231-1보다 작거나 같은 자연수 또는 0이다.

출력
첫째 줄에 최대 사용할 수 있는 회의의 최대 개수를 출력한다.

예제 입력 1 
11
1 4
3 5
0 6
5 7
3 8
5 9
6 10
8 11
8 12
2 13
12 14
*/