package Java.C_Networks.SocketsExamples;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        try (
                ServerSocket welcomeSocket = new ServerSocket(6789)
        ) {

            System.out.println("Server is running on port 6789...");

            while (true) {

                try (
                        Socket connectionSocket = welcomeSocket.accept();

                        BufferedReader inFromClient =
                                new BufferedReader(
                                        new InputStreamReader(
                                                connectionSocket.getInputStream()));

                        DataOutputStream outToClient =
                                new DataOutputStream(
                                        connectionSocket.getOutputStream())
                ) {

                    System.out.println("Client connected.");

                    while (true) {

                        String clientSentence = inFromClient.readLine();

                        if (clientSentence == null) {
                            break;
                        }

                        if (clientSentence.equalsIgnoreCase("exit")) {
                            System.out.println("Client disconnected.");
                            break;
                        }

                        System.out.println("FROM CLIENT: " + clientSentence);

                        String capitalizedSentence =
                                clientSentence.toUpperCase() + '\n';

                        outToClient.writeBytes(capitalizedSentence);
                    }

                } catch (IOException e) {
                    System.out.println("Client connection error: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}