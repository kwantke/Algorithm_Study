package Test2;

import java.util.Arrays;

public class Test54_Checking {
	
	static boolean[] checked;
	public static void main(String[] args){
		
		long sum = 18/7;
		long aa = 0;
		int n =10;
		int[] times = {7,8,9};
		System.out.println(solution(n,times));
	}
	public static long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        Arrays.sort(times);
        long left = 0;
        long right = (long) n * times[times.length - 1]; //가장 최악의 경우의(오래걸리는) 시간
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0; // 총 심사한 인원
            for (int i = 0; i < times.length; i++) { //빨리 심사하는 심사관 순으로 심사처리
                sum += mid / times[i];
            }
            if (sum < n) { // 해야할 인원보다 심사처리 못함 -> 시간 더 필요
                left = mid + 1;
            } else { // 해야할 인원보다 심사처리 많이함 -> 시간을 줄여서 더 최고 경우의 시간을 만든다.
                right = mid - 1;
                answer = Math.min(answer,mid);
            }
        }
        return answer;
    }
	/*public static long solution(int n, int[] times) {
        long answer = 0;
        
        //checked = new boolean[2];
        boolean[] bools = new boolean[3];
		bools[0] = false;
		bools[1] = false;
		bools[2] = false;
		int[] aa = {2,3,4};
		int sum = 0;
        for(int i=0;i<n;i++){
        	for(int t=0;t<aa.length;t++){
        		
        		if(bools[t]) continue;
        		
        		
        	}
        }
        return answer;
    }*/
	public static int searchBinary(int[] array,int target){
	
		int start = 0;
		int end = array.length - 1;
		int mid = (end + start)/2;
		
		while(end - start>=0){
			
			if(array[mid] == target){
				return mid;
			}else if(array[mid]<= target){
				start = mid+1;
			}else{
				end = mid-1;
			}
			mid = (end+start)/2;
		}
		return -1;
	}
	
}

