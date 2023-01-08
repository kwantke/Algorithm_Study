package Test2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class test {
	public static void main(String[] args) {
		URL url = null;

        URLConnection urlConnection = null;

        // URL 주소

        String sUrl = "http://211.233.76.241:3107";
        //String sUrl = "http://localhost:8080/MEM/CUD001I_infobank.jsp";

        // 파라미터 이름

        String ID = "ID";


        // 파라미터 이름에 대한 값

        String paramValue = "IDIDIDI당";



        try {
            // Post방식으로 전송 하기

            url = new URL(sUrl);

            urlConnection = url.openConnection();

            urlConnection.setDoOutput(true);

            printByOutputStream(urlConnection.getOutputStream(), ID + "=" + paramValue);

            printByInputStream(urlConnection.getInputStream());


        } catch(Exception e) {

            e.printStackTrace();

        }
        
        System.out.println("dd");

    }

   

    // 웹 서버로 부터 받은 웹 페이지 결과를 콘솔에 출력하는 메소드

    public static void printByInputStream(InputStream is) {

        byte[] buf = new byte[1024];

        int len = -1;

       

        try {

            while((len = is.read(buf, 0, buf.length)) != -1) {

                System.out.write(buf, 0, len);

            }

        } catch(IOException e) {

            e.printStackTrace();

        }

    }
    // 웹 서버로 파라미터명과 값의 쌍을 전송하는 메소드

    public static void printByOutputStream(OutputStream os, String msg) {

        try {

            byte[] msgBuf = msg.getBytes("UTF-8");

            os.write(msgBuf, 0, msgBuf.length);

            os.flush();

        } catch(IOException e) {

            e.printStackTrace();
        }
	}
}
