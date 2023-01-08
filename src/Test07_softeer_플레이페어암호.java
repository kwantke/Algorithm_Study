import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Test07_softeer_플레이페어암호 {
    static String mes="";
    static String key="";

    static HashMap<Character,Integer> checkMap = new HashMap<Character,Integer>();
    static char[][] plyList;
    static ArrayList<Character> resList;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";
        if((str = br.readLine())!= null){
            if(str.length()<=1000)
                mes = str.toUpperCase();
        }else {
            return;
        }


        str =br.readLine();
        if(str!=null){
            if(str.length()<=100)
                key = str.toUpperCase();
        } else {
            return;
        }
        int N = 5;
        int k = 0, j=65;
        char[] keyList= key.toCharArray();
        if(keyList == null){
           keyList = new char[0];
        }

        plyList = new char[5][5];
        int keyN = keyList.length;
        for(int i=0;i<N;i++){
            for(int t=0;t<N;t++){
                if(k < keyN){
                    while(checkKey(keyList[k])){
                        k++;
                        if(k==keyN){
                            break;
                        }
                    }
                    if(k==keyN){
                        t--;
                        continue;
                    }
                    plyList[i][t] = keyList[k];
                } else{
                    while(checkKey((char)j)){
                        j++;
                    }
                    plyList[i][t] = (char)j;
                }
            }
        }

        ArrayList<String> twoList = new ArrayList<>();
        for(int i=0;i<mes.length();i++){
            if(i == mes.length()-1){
                twoList.add(mes.substring(mes.length()-1,mes.length())+"X");
                continue;
            }
            String tempStr = mes.substring(i,i+2);
            if(chk(tempStr.toCharArray())){
                if("XX".equals(tempStr)){
                    twoList.add(tempStr.substring(0,1)+"Q");
                } else{
                    twoList.add(tempStr.substring(0,1)+"X");
                }
            } else{
                twoList.add(tempStr);
                i = i+1;
            }
        }
        resList = new ArrayList<>();
        for(int a=0;a<twoList.size();a++){
            char[] twoAlpa = twoList.get(a).toCharArray();
            char a1 = twoAlpa[0];
            char a2 = twoAlpa[1];
            int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
            for(int i=0;i<N;i++){
                for(int t=0;t<N;t++){

                    char temp = plyList[i][t];
                    if(temp == 'J') temp = 'I';
                    if(a1 == temp){
                        x1=t; y1=i;
                    } else if(a2 == temp){
                        x2=t; y2=i;
                    }
                }
            }
            addResult(x1,y1,x2,y2);
        }
        for(int i=0;i<resList.size();i++){
            System.out.print(resList.get(i));
        }
    }
    public static void addResult(int x1, int y1, int x2, int y2){
        int x=0,y=0;
        if(x1 == x2 && y1 == y2){
            x = x1+1;
            if(x == 5) x = 0;
            resList.add(plyList[y1][x]);
            resList.add(plyList[y1][x]);

        } else if(x1 == x2){
            y = y1+1;
            if(y == 5) y = 0;
            resList.add(plyList[y][x1]);
            y = y2 + 1;
            if(y == 5) y = 0;
            resList.add(plyList[y][x2]);
        } else if(y1 == y2){
            x = x1+1;
            if(x == 5) x = 0;
            resList.add(plyList[y1][x]);
            x = x2 + 1;
            if(x == 5) x = 0;
            resList.add(plyList[y2][x]);
        } else {
            resList.add(plyList[y1][x2]);
            resList.add(plyList[y2][x1]);
        }
    }
    public static boolean chk(char[] chr){
        char chr1 = chr[0];
        char chr2 = chr[1];
        if(chr1 == chr2){
            return true;
        }else{
            return false;
        }
    }
    public static boolean checkKey(char chr){
        if(chr == 'J'){
            chr = 'I';
        }
        if(checkMap.containsKey(chr)){
            return true;
        }

        checkMap.put(chr, 1);
        return false;
    }
}
