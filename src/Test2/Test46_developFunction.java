package Test2;

import java.util.HashMap;
import java.util.Map;


public class Test46_developFunction {
	
	public static void main(String[] args){
		
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		int[] progresses2= {95, 90, 99, 99, 80, 99};
		int[] speeds2 = {1, 1, 1, 1, 1, 1}; 
		int a = 70;
		int b = 30;
		int result = a/b;
		System.out.println(result);
		//System.out.println(solution(progresses, speeds));
		//System.out.println(solution(progresses2, speeds2));
		
	}
	
	static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        int [] days = new int[100];
        for(int i=0;i<progresses.length;i++){
        	int left = 100 - progresses[i];
        	int day = left/speeds[i];
        	if(day*speeds[i] < left){
        		day++;
        	}
        	days[i] = day;
        }
        int seq = 0;
        int count = 1;
        answer = new int[progresses.length];
        
		answer[0] = 1;
        for(int i=0;i<progresses.length-1;i++){
        	
        	if(days[i]>=days[i+1]){        		
        		days[i+1] = days[i];
        		answer[seq] = answer[seq]+1;
        	} else {
        		seq++;
        		answer[seq] = 1;
        		
        	}
        }
        int[] rs = new int[seq+1];
        for(int i=0;i<=seq;i++){
        	rs[i] = answer[i];
        }
        return rs;
    }
}
/*
 [93, 30, 55]	[1, 30, 5]	[2, 1]
[95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]
*/