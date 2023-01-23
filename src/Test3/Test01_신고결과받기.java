package Test3;

import java.util.*;
import java.util.stream.Collectors;

public class Test01_신고결과받기 {

  static String[] id_list = {"muzi", "frodo", "apeach", "neo"};
  static String[] report = {"muzi frodo","muzi frodo","muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
  static int k = 2;
  public static void main(String[] args){
    solution(id_list,report,k);
  }
  public static int[] solution(String[] id_list, String[] report, int k) {

    List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());
    HashMap<String, Integer> count = new HashMap<>();
    for (String s : list) {
      String target = s.split(" ")[1];
      count.put(target, count.getOrDefault(target, 0) + 1);
    }

    return Arrays.stream(id_list).map(_user -> {
      final String user = _user;
      List<String> reportList = list.stream().filter(s -> s.startsWith(user + " ")).collect(Collectors.toList());
      return reportList.stream().filter(s -> count.getOrDefault(s.split(" ")[1], 0) >= k).count();
    }).mapToInt(Long::intValue).toArray();

    /*int[] answer = {};
    Map idMap = new HashMap<String, Integer>();
    int i = 0;
    for(String id : id_list){
      idMap.put(id,i);
      i++;
    }

    int[][] reportArr = new int[id_list.length][id_list.length];
    for(String str : report){
      String[] reportIds = str.split(" ");
      Integer aId = (Integer) idMap.get(reportIds[0]);
      Integer bId = (Integer) idMap.get(reportIds[1]);
      if(reportArr[aId][bId] < 1){
        reportArr[aId][bId] = 1;
      }
    }

    ArrayList<Integer> sendMailIdlist = new ArrayList<>();

    for(int t=0;t<id_list.length;t++){
      int sum = 0;
      for(int r=0;r<id_list.length;r++){
        sum += reportArr[r][t];
      }
      if(sum >= k)
        sendMailIdlist.add(t);
    }

    answer = new int[id_list.length];
    for(int t=0;t<id_list.length;t++){
      for(Integer r : sendMailIdlist){
        answer[t] += reportArr[t][r];
      }
    }
    //return answer;
    */




  }
}
