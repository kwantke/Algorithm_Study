import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test10_거리의합구하기2 {
    public static int N;
    public static long ans[];
    public static int parent[];
    public static int childCnt[];
    public static class Node{
        int num;
        long cost;
        public Node(){}
        public Node(int a,long b){
            num = a;
            cost = b;
        }
    }
    public static class Info{
        int branchCnt;
        long costSum;
    }

    public static ArrayList<Node> adj[];

    public static Info dfs(int curNode, int par){
        Info ret = new Info();
        parent[curNode] = par;
        for(int i=0;i<adj[curNode].size();i++){
            int nextNode = adj[curNode].get(i).num;
            long cost = adj[curNode].get(i).cost;
            if(nextNode==par) continue;
            Info child = dfs(nextNode,curNode);
            ret.costSum += cost * child.branchCnt + child.costSum;
            ret.branchCnt += child.branchCnt;
        }
        ret.branchCnt +=1;
        childCnt[curNode] = ret.branchCnt;
        return ret;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N+1];
        ans = new long[N+1];
        parent = new int[N+1];
        childCnt = new int[N+1];
        for(int i=1;i<=N;i++){
            adj[i] = new ArrayList<Node>();
        }

        for(int i=0;i<N-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e= Integer.parseInt(st.nextToken());
            long c = Integer.parseInt(st.nextToken());
            adj[s].add(new Node(e,c));
            adj[e].add(new Node(s,c));
        }
        Info root = dfs(1,0);
        ans[1] = root.costSum;
        Queue<Node> q = new LinkedList<Node>();
        for(int i=0;i<adj[1].size();i++){
            q.add(new Node(adj[1].get(i).num,0));
        }
        while(!q.isEmpty()){
            Node curNode = q.poll();
            for(int i=0;i<adj[curNode.num].size();i++){
                int nextNode = adj[curNode.num].get(i).num;
                long cost = adj[curNode.num].get(i).cost;

                if(parent[curNode.num]==nextNode){
                    ans[curNode.num]+= ans[nextNode] + (N-2*childCnt[curNode.num])*cost;
                    continue;
                }

                q.add(new Node(nextNode,0));
            }
        }
        for(int i=1;i<=N;i++){
            System.out.println(ans[i]);
        }
    }
}
