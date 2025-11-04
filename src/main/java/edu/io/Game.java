package edu.io;

import edu.io.token.PlayerToken;

public class Game {

    Board board;
    Player player;

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
        board.clean();
        board.randomlyPlaceGold(10);
    }
}
