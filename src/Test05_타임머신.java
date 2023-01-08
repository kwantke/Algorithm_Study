import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Test05_타임머신 {

    //N: 출발지, M: 버스노선 개수
    static int N,M;

    //busDistList: 정점간에 걸리는 시간
    static ArrayList<BusLine>[] busDistList;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        busDistList = new ArrayList[N+1];
        boolean[] checked = new boolean[N+1];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            //p1-p2: p1에서 p2까지 걸리는 시간
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            if(!checked[p1]){
                busDistList[p1] = new ArrayList();
                checked[p1] = true;
            }
            busDistList[p1].add(new BusLine(p2,time));
        }

        StringBuffer sb =new StringBuffer();
        int[] dist = shortDist(1);
        for(int i=2;i<N+1;i++){
            if(dist[i] == Integer.MAX_VALUE || dist[i] < 0){
                sb.append(-1);
                sb.append("\n");
            }
        }


    }
    public static int[] shortDist(int start){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] dist = new int[N+1];
        for(int i=0;i<N+1;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;
        pq.offer(start);
        while(!pq.isEmpty()){
            int startBus = pq.poll();

            for(BusLine busLine: busDistList[startBus]){
                int desBus = busLine.desBus;
                int time = busLine.time;
                if(dist[desBus]> dist[startBus]+time){
                    dist[desBus] = dist[startBus] + time;
                    pq.offer(desBus);
                }
            }
        }
        return dist;
    }
}
class BusLine implements Comparable<BusLine>{
    int desBus;
    int time;

    public BusLine(int desBus, int time){
        this. desBus = desBus;
        this.time = time;
    }

    @Override
    public int compareTo(BusLine o) {
        if(this.desBus> o.desBus){
            return 1;
        } else{
            return 0;
        }
    }
}

/*
예제 입력 1
3 4
1 2 4
1 3 3
2 3 -1
3 1 -2
예제 출력 1
4
3
예제 입력 2
3 4
1 2 4
1 3 3
2 3 -4
3 1 -2
예제 출력 2
-1
예제 입력 3
3 2
1 2 4
1 2 3
예제 출력 3
3
-1
 */
