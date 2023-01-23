package Test4;

import java.util.Collections;
import java.util.PriorityQueue;

public class test04_02_야근지수 {

  public static void main(String[] args){
    int[] works = {1, 1};
    int n = 3;
    System.out.println(solution(n, works));

  }
  public static long solution(int n, int[] works){
    long answer = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    for(int work : works){
      pq.add(work);
    }
    for(int i=0;i<n;i++){
      if(pq.isEmpty() || pq.peek() == 0)
        break;
      int decreaseWork = pq.poll() - 1;
      if(decreaseWork != 0)
        pq.add(decreaseWork);
    }
    long sum = 0;
    while(!pq.isEmpty()){
      sum +=Math.pow(pq.poll(), 2);
    }
    return sum;
  }
}
