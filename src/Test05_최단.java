public class Test05_최단 {

    static int N;
    public static void main(String[] args){

        String str = "1234";
        solution(str);
        //System.out.println(str);
    }
    static int solution(String str){

        int answer = 0;
        N = str.length();
        StringBuffer sb =new StringBuffer();
        dfs(0,0,str.toCharArray(), sb);

        boolean[] checked = new boolean[N];
        //dfs2(0,checked,str.toCharArray(),sb);
        return answer;
    }

    public static void dfs(int idx, int cnt, char[] chr, StringBuffer sb){
        if(cnt == 2){
            System.out.println(sb.toString());
            return;
        }
        for(int i=idx;i<chr.length;i++){
            sb.append(chr[i]);
            //System.out.println(sb.toString());
            dfs(i+1,cnt+1,chr,sb);
            sb.delete(cnt,cnt+1);
        }
    }

    public static void dfs2(int idx, boolean[] checked, char[] chr, StringBuffer sb){

        if(idx == N){
            System.out.println(sb.toString());
            return;
        }
        for(int i=0;i<chr.length;i++){
            if(checked[i]) continue;
            checked[i] = true;
            sb.append(chr[i]);
            dfs2(idx+1,checked,chr,sb);
            sb.delete(idx, idx+1);
            checked[i] = false;
        }
    }

}
