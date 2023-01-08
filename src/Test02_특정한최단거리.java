import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Test02_특정한최단거리 {
    //N: 정점 번호, M: 간선의 길이
    static int N,M;
    //list: 점점간 길이
    static ArrayList<Node2>[] list;
    // V1, V2: 반드시 지나야하는 정점
    static int V1,V2;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];

        boolean[] checked =new boolean[N+1];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            //해당 정점에 연결된 정점이 있는지 체크
            if(!checked[start]){
                list[start] = new ArrayList<>();
                checked[start] = true;
            }
            if(!checked[end]){
                list[end] = new ArrayList<>();
                checked[end] = true;
            }
            //방향이 없으므로 양방향으로 추가해준다.
            list[start].add(new Node2(end,len));
            list[end].add(new Node2(start,len));
        }

        st = new StringTokenizer(br.readLine());
        V1 = Integer.parseInt(st.nextToken());
        V2 = Integer.parseInt(st.nextToken());

        // V1,V2를 지나야 하므로 각 구간별로 최단 거리 값을 가져옴
        // start -> V1 -> V2 -> end
        int res1 = 0;
        res1 += shortLen(1, V1);
        res1 += shortLen(V1, V2);
        res1 += shortLen(V2,N);

        // start -> V2 -> V1 -> end
        int res2 = 0;
        res2 += shortLen(1,V2);
        res2 += shortLen(V2,V1);
        res2 += shortLen(V1,N);

        // res1, res2 중 최단거리 출력
        System.out.println(Math.min(res1,res2));
    }

    public static int shortLen(int start, int point){

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.add(start);

        //각 정점별 최단거리
        int dist[] = new int[N+1];

        for(int i=0;i<N+1;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start]=0;

        while(!pq.isEmpty()){
            int temStart = pq.poll();
            if(list[temStart] == null) continue;
            for(Node2 node: list[temStart]){
                int end = node.end;
                int len = node.len;
                if(dist[end]>dist[temStart] + len) {
                    dist[end] = dist[temStart] + len;
                    pq.add(end);
                }
            }
        }
        return dist[point];
    }
}
class Node2 implements Comparable<Node2>{
    int end;
    int len;

    public Node2(int end, int len){
        this.end = end;
        this.len = len;
    }

    @Override
    public int compareTo(Node2 o) {
        if(this.end>o.end){
            return 0;
        } else{
            return 1;
        }

    }
}
/*
4 6
1 2 3
2 3 3
3 4 1
1 3 5
2 4 5
1 4 4
2 3
* */