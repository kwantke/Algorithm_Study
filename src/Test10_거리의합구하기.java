import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test10_거리의합구하기 {

    static int N;
    static ArrayList<SumNode>[] point;
    static Queue<Integer> pq;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        if(N<1 || N>2*Math.pow(10,5)){
            return ;
        }
        point = new ArrayList[N+1];
        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            if(l>1000000){
                return;
            }
            if(point[s] == null)
                point[s] = new ArrayList();
            if (point[e] == null) {
                point[e] = new ArrayList();
            }
            point[s].add(new SumNode(e,l));
            point[e].add(new SumNode(s,l));
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<N+1;i++){
            sb.append(getSum(i)+"\n");
        }
        System.out.println(sb.toString());
    }
    public static long getSum(int s){

        long[] dist = new long[N+1];
        int INF = 1000000;
        Arrays.fill(dist, INF);
        dist[0] = 0;
        dist[s] = 0;
        pq = new LinkedList<>();
        pq.offer(s);
        while(!pq.isEmpty()){
            int sp = pq.poll();
            for(SumNode node : point[sp]){
                if(dist[node.end]>dist[sp]+node.len){
                    pq.offer(node.end);
                    dist[node.end] = dist[sp] + node.len;

                }
            }
        }
        return Arrays.stream(dist).sum();
    }
}

class SumNode{
    int end;
    long len;

    public SumNode(int end, long len){
        this.end = end;
        this.len = len;
    }
}
/*
입력예제1
4
1 2 1
2 3 2
3 4 4
출력예제1
11
9
9
17
입력예제2
7
1 2 5
1 3 2
1 4 8
3 5 4
3 6 1
4 7 6
출력예제2
38
63
40
62
60
45
92
 */
