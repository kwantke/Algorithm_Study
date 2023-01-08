package Test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*로또의 최고 순위와 최저 순위

 * */
public class Test02_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		int[] lottosArry = {44, 1, 0, 0, 31, 25};
		int[] winArry = {31, 10, 45, 1, 6, 19};
		*/
		
		/*
		int[] lottosArry = {0, 0, 0, 0, 0, 0};
		int[] winArry = {38, 19, 20, 40, 15, 25};
		*/

		int[] lottosArry = {45, 4, 35, 20, 3, 9};
		int[] winArry = {20, 9, 3, 45, 4, 35};
		
		int[] answer = solution(lottosArry,winArry);
		System.out.println(Arrays.toString(answer));
	}
	public static int[] solution(int[] lottos, int[] win_nums){
		
		int[] answer = new int[2];
		List<Integer> lottosList = new ArrayList<>();
		List<Integer> winList = new ArrayList<>();
		int t =0;
		for(int num:lottos){
			lottosList.add(num);
			winList.add(win_nums[t]);
			t++;
		}		
		int count = 0;
		int zeroCount = 0;
		for(int num:lottosList){
			if(winList.contains(num)){
				count++;
			}
			if(num == 0)
				zeroCount++;
		}		
		int max=0;
		int min=0;
		max = 7 - (count+zeroCount);
		if(count != 0)
			min = 7 - count;
		else
			min = 6;
		
		answer[0] = max;
		answer[1] = min;
		return answer;
	}
}

