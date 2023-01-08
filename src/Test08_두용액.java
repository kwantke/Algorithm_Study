import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test08_두용액 {
    //N: 용액 개수
    static int N;
    //cheList: 각 용액
    static int[] cheList;
    //min: 최소가되는 회석액 값
    static int min = Integer.MAX_VALUE;
    //resultArr: 값이 최소일때 사용된 용액
    static int[] resultArr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        cheList = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            cheList[i] = Integer.parseInt(st.nextToken());
        }
        //useChe: 사용된 용액
        int[] useChe = new int[2];
        resultArr = new int[2];
        boolean[] check = new boolean[N];
        dfs(0,0,cheList,useChe,check);


        for(int i=0;i<2;i++){
            System.out.print(resultArr[i]+" ");
        }
        System.out.println();
    }
    public static void dfs(int idx,int cnt, int[] cheArr,int[] useChe,boolean[] check){

        if(cnt == 2){
            int sum = 0;
            for(int i=0;i<2;i++){
                sum +=useChe[i];
            }
            if(Math.abs(sum)<min){
                min = Math.abs(sum);
                resultArr = useChe.clone();
            }
            return;
        }

        for(int i=idx;i<cheArr.length;i++){
            if(check[i]) continue;
            check[i] = true;
            useChe[cnt] = cheArr[i];
            dfs(i+1,cnt+1,cheArr,useChe,check);
            check[i] = false;
            useChe[cnt]=0;
        }
    }
}
