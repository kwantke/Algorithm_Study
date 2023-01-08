import java.io.*;
import java.util.StringTokenizer;

public class Test03_숨박꼭질3 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st =new StringTokenizer(br.readLine());

        //N: 술래, M: 잡아야할 대상
        int N = Integer.parseInt(st.nextToken());
        double M = Integer.parseInt(st.nextToken());
        int n = N;

        //count: 걸린 시간
        int count = 0;
        while(n != M){
            if(2*n <= M){
                n = 2*n;
            } else{ //2*n > M
                if(n<M){
                    double tem = Math.round(M/2);
                    if(n<=tem)
                        n= n*2;
                    else{
                        if(2*n - M < tem){
                            n = n-1;
                            count++;
                        } else{
                            n = n+1;
                            count++;
                        }
                    }
                } else{
                    n = n-1;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
