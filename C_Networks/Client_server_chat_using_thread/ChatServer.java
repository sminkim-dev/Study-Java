package C_Networks.Client_server_chat_using_thread;

//import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {

    // 접속한 모든 클라이언트 저장
    private static Vector<ClientThread> clients = new Vector<>();

    public static void main(String[] args) {

        try {
            // 채팅 서버 소켓을 close 안해서 생기는 경고인데, 보통 서버는 무한 실행이라 일부러 안 닫는 경우도 있음. 실행은 정상이어야 함.
            // 해당 부분은 package 내 .java 파일에 close 존재, 하지만 지금 열린 파일 기준으로 close 된 것이 없기에 경고를 띄우는
            // 것.
            ServerSocket serverSocket = new ServerSocket(6789);

            Runtime.getRuntime().addShutdownHook(
                    new Thread(() -> {
                        try {
                            serverSocket.close();
                        } catch (Exception e) {
                        }
                    }));
            System.out.println("채팅 서버 시작");

            while (true) {

                Socket socket = serverSocket.accept();

                System.out.println("클라이언트 접속 : "
                        + socket.getInetAddress());

                ClientThread clientThread = new ClientThread(socket);

                clients.add(clientThread);

                clientThread.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 모든 클라이언트에게 메시지 전송
    public static void broadcast(String msg) {

        synchronized (clients) {

            for (ClientThread ct : clients) {

                try {
                    ct.sendMessage(msg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 클라이언트 제거
    public static void removeClient(ClientThread client) {

        synchronized (clients) {
            clients.remove(client);
        }
    }
}