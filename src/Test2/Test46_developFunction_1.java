package Test2;

import java.util.HashMap;
import java.util.Map;


public class Test46_developFunction_1 {
	
	public static void main(String[] args){
		
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		int[] progresses2= {95, 90, 99, 99, 80, 99};
		int[] speeds2 = {1, 1, 1, 1, 1, 1}; 
		int[] result = solution(progresses,speeds);
		for(int i:result){
			System.out.print(i+" ");
		}
	}
	
	static int[] solution(int[] progresses, int[] speeds) {
		int size = progresses.length;
		int[] answer = {};
        int[] days = new int[size];        
        for(int i=0;i<size;i++){
        	int left = 100 - progresses[i];
        	int day = left/speeds[i];
        	if(day*speeds[i]< left) day++;
        	days[i]=day;
        }
        int seq = 0;
        answer = new int[size];
        for(int i=0;i<size-1;i++){
        	if(days[i]>days[i+1]){
        		days[i+1] = days[i];
        		answer[seq] = answer[seq]+1;
        	}else{
        		answer[seq]=1;
        		seq++;
        	}
        	
        }
        int[] result = new int[seq+1];
        for(int i=0;i<=seq;i++){
        	result[i] = answer[i]+1;
        }
        return result;
    }
}
/*
 [93, 30, 55]	[1, 30, 5]	[2, 1]
[95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]
*/