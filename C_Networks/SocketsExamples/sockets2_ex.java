package C_Networks.SocketsExamples;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
public class sockets2_ex {
    public static void main(String [] argv) throws Exception{
        // 테스트용 argument
        argv = new String[]{"https://www.naver.com"};

        URL url = new URL(argv[0]);

        System.out.println("Host: " + url.getHost());
        System.out.println("Protocol: " + url.getProtocol());
        System.out.println("----");

        URLConnection con = url.openConnection();

        InputStream stream = con.getInputStream();

        byte[] data = new byte[4096];
        int bytesRead = 0;

        while ((bytesRead = stream.read(data)) >= 0) {
            System.out.write(data, 0, bytesRead); // write를 쓴 이유는 byte타입으로 읽어오기 때문에 write를 이용하여 출력함.
        }

        stream.close();
    }
}
