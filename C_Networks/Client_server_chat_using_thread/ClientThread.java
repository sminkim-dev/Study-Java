package C_Networks.Client_server_chat_using_thread;

import java.io.*;
import java.net.*;

public class ClientThread extends Thread {

    private Socket socket;

    private BufferedReader in;
    private DataOutputStream out;

    private String nickname;

    public ClientThread(Socket socket) {

        this.socket = socket;

        try {

            in = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()
                    )
            );

            out = new DataOutputStream(
                    socket.getOutputStream()
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 클라이언트에게 메시지 보내기
    public void sendMessage(String msg) {

        try {
            out.writeBytes(msg + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        try {

            // 최초 닉네임 입력
            out.writeBytes("닉네임 입력 : \n");

            nickname = in.readLine();

            ChatServer.broadcast(
                    "[" + nickname + "] 입장"
            );

            while (true) {

                String msg = in.readLine();

                // 연결 종료
                if (msg == null || msg.equals("exit")) {
                    break;
                }

                System.out.println(
                        nickname + " : " + msg
                );

                ChatServer.broadcast(
                        nickname + " : " + msg
                );
            }

        } catch (Exception e) {

            System.out.println("연결 종료");

        } finally {

            try {

                ChatServer.removeClient(this);

                ChatServer.broadcast(
                        "[" + nickname + "] 퇴장"
                );

                socket.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
