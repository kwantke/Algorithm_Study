import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    // end: 다음 번호 값, val: 가중치
    int end;
    int val;
    public Node(){};
    public Node(int end, int val){
        this.end = end;
        this.val = val;
    }

    @Override
    public int compareTo(Node o) {
        if(this.end> o.end){
            return 1;
        }
        return 0;
    }
}
public class Test01_최단거리 {


    //N: 정점의 개수, M: 간선 개수
    static int N,M;

    //start: 시작 번호
    static int start;
    // list: 각 번호별 연결되어 있는 번호와 그 가중치
    static ArrayList<Node>[] list;

    //dist: 각 정점별 최소 가중치
    static int[] dist;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());


        // list: 각 번호별 연결되어 있는 번호와 그 가중치
        list = new ArrayList[N+1];
        boolean[] check = new boolean[N+1];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            //str: 시작 정정, end: 연결된 정정, val: 해당 가중치
            int str = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            if(!check[str]){
                list[str] = new ArrayList<>();
                check[str] = true;
            }
            list[str].add(new Node(end,value));
        }
        bfs(start);

        for(int i=1;i<N+1;i++){

            if(dist[i] == Integer.MAX_VALUE){
                System.out.println("INF");
                continue;
            }
            System.out.println(dist[i]);
        }
    }
    public static void bfs(int start){
        //pq: 시작점
        PriorityQueue<Integer> pq = new PriorityQueue();
        pq.add(start);
        //dist: 각 정점별 최소 가중치
        dist = new int[N+1];
        //가중치를 최대값으로 초기화
        for(int i=1;i<N+1;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        //시작 정점 초기화
        dist[start] = 0;
        while(!pq.isEmpty()){
            int point = pq.poll();
            
            if(list[point] == null) continue;
            for(Node nod : list[point]){
                // 연결된 다음정점 값 및 가중치
                int nextNum = nod.end;
                int val = nod.val;
                if(dist[nextNum]>dist[point]+val) {
                    dist[nextNum] = dist[point] + val;
                    pq.add(nextNum);
                }
            }
        }
        
    }
}


/*
최단경로
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	256 MB	140053	40321	19956	24.446%
문제
방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 구하는 프로그램을 작성하시오. 단, 모든 간선의 가중치는 10 이하의 자연수이다.

입력
첫째 줄에 정점의 개수 V와 간선의 개수 E가 주어진다. (1 ≤ V ≤ 20,000, 1 ≤ E ≤ 300,000) 모든 정점에는 1부터 V까지 번호가 매겨져 있다고 가정한다. 둘째 줄에는 시작 정점의 번호 K(1 ≤ K ≤ V)가 주어진다. 셋째 줄부터 E개의 줄에 걸쳐 각 간선을 나타내는 세 개의 정수 (u, v, w)가 순서대로 주어진다. 이는 u에서 v로 가는 가중치 w인 간선이 존재한다는 뜻이다. u와 v는 서로 다르며 w는 10 이하의 자연수이다. 서로 다른 두 정점 사이에 여러 개의 간선이 존재할 수도 있음에 유의한다.

출력
첫째 줄부터 V개의 줄에 걸쳐, i번째 줄에 i번 정점으로의 최단 경로의 경로값을 출력한다. 시작점 자신은 0으로 출력하고, 경로가 존재하지 않는 경우에는 INF를 출력하면 된다.

예제 입력 1
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6
예제 출력 1
0
2
3
7
INF
* */