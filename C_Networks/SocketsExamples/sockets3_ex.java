package Java.C_Networks.SocketsExamples;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class sockets3_ex {
    private final String USER_AGENT = "Mozilla/5.0";
    public static void main(String [] argv) throws Exception{
        sockets3_ex http = new sockets3_ex();

        System.out.println("GET으로 데이터 가져오기");
        http.sendGet("https://example.com");

        System.out.println("\n-----------------------------\n");

        System.out.println("POST로 데이터 가져오기");

        String urlParameters =
                "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";

        http.sendPost(
                "https://httpbin.org/post",
                urlParameters
        );
    }
    // HTTP GET 요청
    private void sendGet(String targetUrl) throws Exception {

        URL url = new URL(targetUrl);

        HttpURLConnection con =
                (HttpURLConnection) url.openConnection();

        // GET 방식 설정
        con.setRequestMethod("GET");

        // Header 추가
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();

        BufferedReader in =
                new BufferedReader(
                        new InputStreamReader(con.getInputStream())
                );

        String inputLine;

        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        in.close();

        // 결과 출력
        System.out.println("HTTP 응답 코드 : " + responseCode);

        System.out.println("HTTP body : ");
        System.out.println(response.toString());
    }

    // HTTP POST 요청
    private void sendPost(
            String targetUrl,
            String parameters
    ) throws Exception {

        URL url = new URL(targetUrl);

        HttpsURLConnection con =
                (HttpsURLConnection) url.openConnection();

        // POST 방식 설정
        con.setRequestMethod("POST");

        con.setRequestProperty("User-Agent", USER_AGENT);

        // POST 데이터 전송 허용
        con.setDoOutput(true);

        // POST 데이터 전송
        DataOutputStream wr =
                new DataOutputStream(con.getOutputStream());

        wr.writeBytes(parameters);

        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();

        BufferedReader in =
                new BufferedReader(
                        new InputStreamReader(con.getInputStream())
                );

        String inputLine;

        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        in.close();

        // 결과 출력
        System.out.println("HTTP 응답 코드 : " + responseCode);

        System.out.println("HTTP body : ");
        System.out.println(response.toString() + "\n");
    }
}
