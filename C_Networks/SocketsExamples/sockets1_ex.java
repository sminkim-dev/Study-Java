package C_Networks.SocketsExamples;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class sockets1_ex {

    public static void main(String[] args) {

        args = new String[]{"www.naver.com"};
        
        if (args.length == 0) {
            System.out.println("Usage: java sockets1_ex <hostname>");
            return;
        }

        try {
            // 소켓 생성
            Socket socket = new Socket(args[0], 80);

            // 입력/출력 스트림 생성
            InputStream istream = socket.getInputStream();
            OutputStream ostream = socket.getOutputStream();

            // HTTP 요청 생성
            String request =
                    "GET / HTTP/1.1\r\n" +
                    "Host: " + args[0] + "\r\n" +
                    "Connection: close\r\n\r\n";

            // 요청 전송
            ostream.write(request.getBytes());

            // 헤더 읽기
            StringBuffer headers = new StringBuffer();
            int byteRead = 0;

            while (!endOfHeaders(headers)
                    && (byteRead = istream.read()) >= 0) {

                headers.append((char) byteRead);
            }

            // 출력
            System.out.print(headers);

            // 소켓 종료
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // HTTP 헤더 종료 여부 확인
    public static boolean endOfHeaders(StringBuffer headers) {

        int lastIndex = headers.length() - 1;

        if (lastIndex < 3 || headers.charAt(lastIndex) != '\n') {
            return false;
        }

        return headers.substring(lastIndex - 3, lastIndex + 1)
                      .equals("\r\n\r\n");
    }
}
