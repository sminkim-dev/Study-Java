package Java.C_Networks.SocketsExamples;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {

        try (
                Socket clientSocket = new Socket("localhost", 6789);

                BufferedReader inFromUser =
                        new BufferedReader(
                                new InputStreamReader(System.in));

                DataOutputStream outToServer =
                        new DataOutputStream(
                                clientSocket.getOutputStream());

                BufferedReader inFromServer =
                        new BufferedReader(
                                new InputStreamReader(
                                        clientSocket.getInputStream()))
        ) {

            System.out.println("Connected to server.");
            System.out.println("Type 'exit' to quit.");

            while (true) {

                System.out.print("Input: ");

                String sentence = inFromUser.readLine();

                if (sentence == null) {
                    break;
                }

                outToServer.writeBytes(sentence + '\n');

                if (sentence.equalsIgnoreCase("exit")) {
                    break;
                }

                String modifiedSentence = inFromServer.readLine();

                System.out.println("FROM SERVER: " + modifiedSentence);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}