import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Test06_타임머신_벨만포드 {

    static int N,M;
    static ArrayList<Bus> busList;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        busList = new ArrayList<>();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            busList.add(new Bus(start,end,time));
        }

        int[] dist = new int[N+1];
        int INF = 10000000;
        Arrays.fill(dist,INF);
        dist[1] = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                Bus bus = busList.get(j);
                if(dist[bus.start] != INF && dist[bus.end]>dist[bus.start]+bus.time){
                    dist[bus.end] = dist[bus.start] + bus.time;
                }
            }
        }
        //가중치를 비교하여 순환을 체크함
        for(int i=0;i<M;i++){
            Bus bus = busList.get(i);
            if(dist[bus.start] != INF && dist[bus.end]>dist[bus.start]+bus.time){
                System.out.println("순환");
                return;
            }
        }

        for(int i=2;i<N+1;i++){
            if(dist[i] == INF){
                System.out.println("-1");
            } else
                System.out.println(dist[i]);
        }
    }
}
class Bus {
    int start;
    int end;
    int time;

    public Bus(int start, int end, int time){
        this.start = start;
        this.end = end;
        this.time = time;
    }
}