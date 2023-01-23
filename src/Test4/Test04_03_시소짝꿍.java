package Test4;

import java.util.*;

public class Test04_03_시소짝꿍 {
  static int count = 0;
  public static void main(String[] args){

    int[] weights = {100,180,360,100,270};

    System.out.println(solution(weights));


  }

  public static long solution(int[] weights) {
    long answer = 0;
    Map<Integer, List<Integer>> ppl = new HashMap<>();

    Set<Integer> pplSet = new HashSet<>();

    for(int i=0;i<weights.length;i++){

      if(!ppl.containsKey(weights[i])){
        List<Integer> list = new ArrayList<>();
        list.add(i);
        ppl.put(weights[i],list);
      } else {
        ppl.get(weights[i]).add(i);
      }

      pplSet.add(weights[i]);
    }

    for(int key : pplSet){
      int pws = ppl.get(key).size();

      int wX2 = key * 2;

      if(wX2 % 3 == 0) {
        if (ppl.containsKey(wX2 / 3)) {
          answer += (long)ppl.get(wX2 / 3).size() * pws;
        }
      }
      if(wX2 % 4 == 0) {
        if (ppl.containsKey(wX2 / 4)) {
          answer += (long)ppl.get(wX2 / 4).size() * pws;
        }
      }

      int wX3 = key *3;
      if(wX3 % 2 == 0) {
        if (ppl.containsKey(wX3 / 2)) {
          answer += (long)ppl.get(wX3 / 2).size() * pws;
        }
      }
      if(wX3 % 4 == 0) {
        if (ppl.containsKey(wX3 / 4)) {
          answer += (long)ppl.get(wX3 / 4).size() * pws;
        }
      }

      int wX4 = key *4;
      if(wX4 % 2 == 0) {
        if (ppl.containsKey(wX4 / 2)) {
          answer += (long)ppl.get(wX4 / 2).size() * pws;
        }
      }
      if(wX4 % 3 == 0) {
        if (ppl.containsKey(wX4 / 3)) {
          answer += (long)ppl.get(wX4 / 3).size() * pws;
        }
      }

      if(pws>1){
        answer += (long)pws *(long)(pws-1)/2;
      }
      ppl.remove(key);

    }


    return answer;
  }

}


