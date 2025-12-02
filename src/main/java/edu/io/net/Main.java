package edu.io.net;

import edu.io.net.command.Command;
import edu.io.net.command.Echo;
import edu.io.net.command.Handshake;
import edu.io.net.command.JoinGame;
import edu.io.net.command.LeaveGame;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {


        String connStr = "tcp://localhost:1313";

        GameServerConnector connector =
                new GameServerConnector(connStr, new SocketConnector());


        connector.onCmdFromServer(cmd -> {
            System.out.println("[SERVER] -> " + cmd);
        });

        System.out.println("Connecting to server...");
        connector.connect()
                .onSuccess(() -> System.out.println("Connected!"))
                .onFailure(() -> {
                    System.out.println("Failed to connect.");
                    System.exit(1);
                });


        connector.issueCommand(new Handshake.Cmd("1.0"));


        connector.issueCommand(new JoinGame.Cmd("ClientUser"));


        Scanner sc = new Scanner(System.in);
        System.out.println("Type messages to send. 'quit' to exit.");

        while (true) {
            System.out.print("> ");
            String line = sc.nextLine().trim();

            if (line.equalsIgnoreCase("quit")) {
                connector.issueCommand(new LeaveGame.Cmd());
                connector.disconnect();
                System.out.println("Disconnected.");
                break;
            }


            connector.issueCommand(new Echo.Cmd(line));
        }
    }
}
