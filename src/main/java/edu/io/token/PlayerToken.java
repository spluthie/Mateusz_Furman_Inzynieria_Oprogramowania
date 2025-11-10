package edu.io.token;

import edu.io.Board;
import edu.io.Player;


public class PlayerToken extends Token{
    public enum Move{
        NONE,
        LEFT,
        RIGHT,
        UP,
        DOWN
    }



    private final Board board;
    private final Player player;
    private int col;
    private int row;


    public PlayerToken(Player player, Board board){
        super(Label.PLAYER_TOKEN_LABEL);

        this.board = board;
        this.player = player;

        this.col = 0;
        this.row = 0;
        board.placeToken(col, row, this);

    }

    public void move(Move dir){

        int newCol = col;
        int newRow = row;
        switch(dir){
            case Move.NONE: break;

            case Move.LEFT: newRow -= 1; break;

            case Move.RIGHT: newRow += 1; break;

            case Move.UP: newCol -= 1; break;

            case Move.DOWN: newCol += 1; break;
        }


        if(newRow < 0 || newRow >= board.size() || newCol < 0 || newCol >= board.size()){
            throw new IllegalArgumentException("Ruch poza plansze");
        }


        board.placeToken(col, row, new EmptyToken());


        board.placeToken(newCol, newRow, this);

        this.row = newRow;
        this.col = newCol;

        var token = board.peekToken(col, row); //SPRAWDZ
        if(token instanceof GoldToken gold){
            player.gainGold(gold.amount());
        }


    }

    public Board.Coords pos() {
        return new Board.Coords(col, row);
    }

    public Board getBoard(){
        return board;
    }


}
