import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Test04_미확인 {

    //C: 케이스 수
    static int C;

    // checked: 정점 생성 여부
    static boolean[] checked;
    
    //list: 각 교차로에 연결관 정점리스트
    static ArrayList<Node3>[] list;
    static BufferedWriter bw;
    static BufferedReader br;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        //C: 케이스 수
        C = Integer.parseInt(st.nextToken());

        int r=0;
        while(r < C){
            //N: 정점(교차로)의 개수, M: 도로 개수, T: 목적지 후보
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            //S: 시작점, G-H: 미확인 경로
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            
            list = new ArrayList[N+1];
            checked = new boolean[N+1];
            boolean unKnown = false;
            for(int i=0;i<M;i++){

                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int len = Integer.parseInt(st.nextToken());

                check(s,checked[s]).add(new Node3(e,len));
                check(e,checked[e]).add(new Node3(s,len));
            }
            int min = Integer.MAX_VALUE;
            ArrayList resList = new ArrayList();
            for(int i=0;i<T;i++){
                st = new StringTokenizer(br.readLine());
                //des: 목적지 후보
                int des = Integer.parseInt(st.nextToken());
                //desLen: 목적지 후보까의 거리
                int desLen = bfs(N, S, des);

                int V1 = 0;
                V1 += bfs(N, S, G);
                V1 += bfs(N, G, H);
                V1 += bfs(N, H, des);
                //출발지에서 목적지까지의 최단 거리와 확인된 위치를 지나치는 거리와 비교
                if(desLen >= V1) {
                    resList.add(des);
                }
            }
            System.out.println(resList.toString());
            r++;
        }

    }

    static ArrayList<Node3> check(int point, boolean pointChecked){
        if(!pointChecked){
            list[point] = new ArrayList<>();
        }
        return  list[point];
    }
    static int bfs(int N, int start, int point){
        PriorityQueue pq = new PriorityQueue();
        int[] dist = new int[N+1];
        for(int i=0;i<N+1;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;
        pq.offer(start);
        while(!pq.isEmpty()){
            int s = (Integer)pq.poll();
            if(list[s] == null) continue;
            for(Node3 node : list[s]){
                int e = node.end;
                int len = node.len;
                if(dist[e] > dist[s] + len){
                    pq.offer(e);
                    dist[e] = dist[s] + len;
                }

            }

        }
        return dist[point];
    }
}

class Node3{

    int end;
    int len;

    public Node3(int end, int len){
        this.end = end;
        this.len = len;
    }
}



/*
첫 번째 줄에는 테스트 케이스의 T(1 ≤ T ≤ 100)가 주어진다. 각 테스트 케이스마다

첫 번째 줄에 3개의 정수 n, m, t (2 ≤ n ≤ 2 000, 1 ≤ m ≤ 50 000 and 1 ≤ t ≤ 100)가 주어진다.
각각 교차로, 도로, 목적지 후보의 개수이다.
두 번째 줄에 3개의 정수 s, g, h (1 ≤ s, g, h ≤ n)가 주어진다.
s는 예술가들의 출발지이고, g, h는 문제 설명에 나와 있다. (g ≠ h)
그 다음 m개의 각 줄마다 3개의 정수 a, b, d (1 ≤ a < b ≤ n and 1 ≤ d ≤ 1 000)가 주어진다.
a와 b 사이에 길이 d의 양방향 도로가 있다는 뜻이다.
그 다음 t개의 각 줄마다 정수 x가 주어지는데, t개의 목적지 후보들을 의미한다.
이 t개의 지점들은 서로 다른 위치이며 모두 s와 같지 않다.
교차로 사이에는 도로가 많아봐야 1개이다. m개의 줄 중에서 g와 h 사이의 도로를 나타낸 것이 존재한다. 또한 이 도로는 목적지 후보들 중 적어도 1개로 향하는 최단 경로의 일부이다.
1
5 4 2
1 2 3
1 2 6
2 3 2
3 4 4
3 5 3
5
4
6 9 2
2 3 1
1 2 1
1 3 3
2 4 4
2 5 5
3 4 3
3 6 2
4 5 4
4 6 3
5 6 7
5
6
*/

