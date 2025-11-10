package edu.io;

import edu.io.token.PlayerToken;

import java.util.Scanner;

import static edu.io.token.PlayerToken.Move.*;

public class Game {

    public Board board;
    Player player;
    PlayerToken token;

    public Game() {
        board = new Board();
        player = new Player();
    }


    public void join(Player player) {
        if (player == null) throw new IllegalArgumentException("player nie może być null");
        Board.Coords coords = board.getAvailableSquare();

        PlayerToken token = new PlayerToken(player, board);

        player.assignToken(token);

        this.player = player;
    }


    public PlayerToken token(){
        if(player == null) return null;
        return player.token();
    }


    public void start() {
        board.randomlyPlaceToken(7, "gold");
        board.randomlyPlaceToken(3, "piryt");

        Scanner scanner = new Scanner(System.in);
        String kierunek;
        while(true){
            board.display();
            kierunek = scanner.nextLine();
            switch (kierunek){
                case "":
                    token().move(NONE);
                    break;
                case "w":
                    token().move(UP);
                    break;
                case "a":
                    token().move(LEFT);
                    break;
                case "s":
                    token().move(DOWN);
                    break;
                case "d":
                    token().move(RIGHT);
                    break;
                default:
                    System.out.println("Bledny znak");
                    break;
            }
        }


    }
}
