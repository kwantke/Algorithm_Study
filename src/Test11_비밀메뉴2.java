import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test11_비밀메뉴2 {
    public static int N,M,K;
    public static int A[],B[];
    public static int dp[][];

    public static int dfs(int i,int j){
        if(i<0 || j <0) return 0;
        if(dp[i][j]!=0) return dp[i][j];
        if(A[i] == B[j]){
            return dp[i][j] = 1 + dfs(i-1,j-1);
        }
        return dp[i][j];
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N];
        B = new int[M];
        dp = new int[N][M];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            B[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                ans = Math.max(dfs(i,j),ans);
            }
        }
        System.out.println(ans);
    }
}
