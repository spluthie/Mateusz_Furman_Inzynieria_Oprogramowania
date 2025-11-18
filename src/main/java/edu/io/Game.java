package edu.io;

import edu.io.player.Player;
import edu.io.token.*;

import java.util.Scanner;

import static edu.io.token.PlayerToken.Move.*;

public class Game {

    public Board board;
    Player player;




    public Game() {
        board = new Board();
        player = new Player();
    }




    public void join(Player player) {
        if (player == null) throw new NullPointerException("player nie może być null");
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
        board.randomlyPlaceToken(7, new GoldToken());
        board.randomlyPlaceToken(3, new PyriteToken());
        board.randomlyPlaceToken(1, new PickaxeToken());
        board.randomlyPlaceToken(1, new AnvilToken());


        Scanner scanner = new Scanner(System.in);
        String kierunek;

        while(true){

            try {
                board.display();
                System.out.println("Nawodnienie: " + player.vitals.hydration() + "/100");
                kierunek = scanner.nextLine();
                switch (kierunek) {
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
            }catch(IllegalStateException e){
                System.out.println("Umarles, nie mozesz sie wiecej ruszac");
                break;
            }

        }

    }

}
