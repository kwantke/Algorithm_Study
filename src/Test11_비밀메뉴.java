import java.io.*;
import java.util.*;

public class Test11_비밀메뉴 {

    static int N,M,K;
    static int max = 0;
    static char[] chrArr;
    static Map<String,Integer> map;
    public static void main(String[] args) throws IOException {

        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] v = br.readLine().split(" ");
        N = Integer.parseInt(v[0]);
        M = Integer.parseInt(v[1]);
        K = Integer.parseInt(v[2]);
        if((N < 1 || N > 3000) || (M < 1 || M > 3000) || (K < 1 || K > 1000000)){
            return;
        }
        String s1 = br.readLine().replaceAll(" ","");
        String s2 = br.readLine().replaceAll(" ","");
        StringBuilder sbPar = new StringBuilder();
        map = new HashMap<String, Integer>();
        chrArr = s1.toCharArray();
        check(0,0,sbPar,1);
        sbPar = new StringBuilder();
        chrArr = s2.toCharArray();
        check(0,0,sbPar,0);

        System.out.println(max);
        br.close();
        //실험할 코드 추가

        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
        System.out.println("시간차이(m) : "+secDiffTime);

    }
    public static void check(int idx,int cnt,StringBuilder sb, int spt){
        if(cnt == N){
            return;
        }
        for(int i=idx;i<chrArr.length;i++){
            sb.append(chrArr[i]);
            if(spt == 1){
                map.put(sb.toString(),0);
            }else {
                if(map.containsKey(sb.toString()) && map.get(sb.toString()) == 0){
                    map.put(sb.toString(),1);
                    max = Math.max(sb.toString().length(), max);
                }
            }
            check(i+1,cnt+1,sb,spt);
            sb.delete(cnt, cnt+1);
        }
    }
    public static void argArr(int idx, StringBuilder sb, char[] chrArr,boolean[] check){

        if(idx == N){
            return;
        }
        for(int i=0;i<chrArr.length;i++){
            if(check[i]) continue;
            check[i] = true;
            sb.append(chrArr[i]);
            System.out.println(sb.toString());
            argArr(idx+1,sb,chrArr,check);
            sb.delete(idx,sb.toString().length());
            check[i]=false;
        }
    }
}

/*
제약조건
1≤N≤3,000

1≤M≤3,000

1≤K≤1,000,000

각 버튼의 번호는 1 이상 K 이하이다.

입력형식
첫째 줄에 N, M, K가 공백을 사이에 두고 주어진다.

둘째 줄에 첫 번째 버튼 조작을 나타내는 N개의 정수가 공백을 사이에 두고 주어진다. 각 정수는 1 이상 K 이하이다.

셋째 줄에 두 번째 버튼 조작을 나타내는 M개의 정수가 공백을 사이에 두고 주어진다. 각 정수는 1 이상 K 이하이다.

출력형식
비밀 메뉴 조작법으로 가능한 가장 긴 것의 길이를 첫째 줄에 출력한다. 만일 겹치는 조작이 전혀 없다면 0을 출력한다.

입력예제1
3 4 4
2 3 1
3 1 4 2
출력예제1
2

입력예제2
4 10 3
2 1 3 2
1 3 2 1 3 2 1 3 2 1
출력예제2
4

입력예제3
5 4 9
3 1 4 1 5
9 8 7 6
출력예제3
0
 */
