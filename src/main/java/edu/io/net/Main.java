package edu.io.net;

import edu.io.net.command.Echo;
import edu.io.net.command.Command;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 1313;

        try (Socket socket = new Socket(host, port)) {


            ObjectOutputStream out =
                    new ObjectOutputStream(socket.getOutputStream());

            ObjectInputStream in =
                    new ObjectInputStream(socket.getInputStream());


            Echo.Cmd echo = new Echo.Cmd("hello from client");
            out.writeObject(echo);
            out.flush();

            System.out.println("Sent: " + echo);


            Command response = (Command) in.readObject();
            System.out.println("Received: " + response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
