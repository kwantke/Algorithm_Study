package Test2;

import java.util.PriorityQueue;

public class Test49_moreSpicy {
	
	public static void main(String[] args){
		//int[] scoville = {1,1,1};
		int[] scoville = {3, 2, 1, 9, 10, 12};
		int K = 7;
		System.out.println(solution(scoville, K));
	}
	
	
	static int solution(int[] scoville, int K) {
		int count = 0;
		
		PriorityQueue<Integer> que = new PriorityQueue<>();
		for(int i:scoville){
			que.offer(i);
		}
		int a =que.peek();
		while(que.peek()<=K){
			if(que.size()<=1) return -1;
			int a1 = que.poll();
			int a2 = que.poll();				
			que.add(a1 + a2*2);
			
			count++;
		}
		return count;
    }
}

/*
if(scoville == null || scoville.length<2) return -1;
		ArrayList<Integer> list = new ArrayList();		   
       int count = -1;
       
       for(int a : scoville){
    	   list.add(a);
       }
       
       Collections.sort(list);
       while(K > list.get(0)){
           if(list == null || list.size() <= 1) return -1;
    	   if(list.size() >= 2){
    		  
               while(list.get(0) == list.get(1)){
            	   if(list.size() == 2){
            		   return count+1;
            	   }
            	   list.remove(1);           	   
               }         
               list.add(list.get(0) + list.get(1)*2);
               list.remove(0);
               list.remove(0);
               
               Collections.sort(list);
               count++;
           
    	   }else {
    		   return -1;
    	   }
       }
       return count+1;
*/
/*
scoville	K	return
[1, 2, 3, 9, 10, 12]	7	2
*/