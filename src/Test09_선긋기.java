import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Test09_선긋기 {

    static int N;
    static Node4[] node;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        node = new Node4[N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            node[i] = new Node4(start, end);
        }
        Arrays.sort(node,(l1, l2)->l1.start - l2.start);

        int len = 0;
        int start = node[0].start;
        int end = node[0].end;
        for(int i=1;i<N;i++){
            Node4 next = node[i];
            if(next.start>=end){
                len += next.end - next.start;
                start = next.start;
                end = next.end;
            }else {
                len = next.end - start;
                end = next.end;
            }
        }
        System.out.println(len);
    }

}
class Node4 {
    int start;
    int end;
    public Node4(int start, int end){
        this.start = start;
        this.end = end;
    }
}