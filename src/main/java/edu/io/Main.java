package edu.io;

import edu.io.token.Label;
import edu.io.token.Token;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Player player = new Player(0, 0);
        int totalGold = 10;
        board.randomlyPlaceGold(totalGold);
        int collectedGold = 0;

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Sterowanie: W/A/S/D + Enter. Q = wyjście.\n");

        while (running) {



            for (int row = 0; row < board.size; row++) {
                for (int col = 0; col < board.size; col++) {
                    if (player.getX() == col && player.getY() == row) {
                        System.out.print("\uC6C3");
                    } else {
                        System.out.print(board.square(col, row).label + " ");
                    }
                }
                System.out.println();
            }
            System.out.println("Zebrane złoto: " + player.getGoldCollected());
            System.out.print("Ruch: ");

            String input = scanner.nextLine().trim().toLowerCase();

            int dx = 0, dy = 0;
            switch (input) {
                case "w": dy = -1; break;
                case "s": dy = 1; break;
                case "a": dx = -1; break;
                case "d": dx = 1; break;
                case "q": running = false; continue;
                default:
                    System.out.println("Nieznany ruch!");
                    continue;
            }

            player.move(dx, dy, board.size);

            Token square = board.square(player.getX(), player.getY());
            if (Label.GOLD_TOKEN_LABEL.equals(square.label)) {
                player.collectGold();
                board.removeGoldAt(player.getX(), player.getY());
                System.out.println("\uD83D\uDCB0 Znalazłeś złoto!");
                collectedGold++;
            }

            System.out.println();
            if(collectedGold==totalGold){
                break;
            }
        }

        System.out.println("Koniec gry! Zebrałeś " + player.getGoldCollected() + " sztuk złota.");
        scanner.close();
    }
}
