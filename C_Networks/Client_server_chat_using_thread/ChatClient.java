package C_Networks.Client_server_chat_using_thread;

import java.io.*;
import java.net.*;

public class ChatClient {

    public static void main(String[] args) {

        try {

            Socket socket =
                    new Socket("127.0.0.1", 6789);

            BufferedReader keyboard =
                    new BufferedReader(
                            new InputStreamReader(System.in)
                    );

            BufferedReader in =
                    new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()
                            )
                    );

            DataOutputStream out =
                    new DataOutputStream(
                            socket.getOutputStream()
                    );

            // 서버 메시지 출력 스레드
            Thread receiveThread = new Thread(() -> {

                try {

                    while (true) {

                        String msg = in.readLine();

                        if (msg == null)
                            break;

                        System.out.println(msg);
                    }

                } catch (Exception e) {

                }
            });

            receiveThread.start();

            // 키보드 입력
            while (true) {

                String msg = keyboard.readLine();

                out.writeBytes(msg + "\n");

                if (msg.equals("exit")) {
                    break;
                }
            }

            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
