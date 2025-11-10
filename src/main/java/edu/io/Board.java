package edu.io;

import edu.io.token.EmptyToken;
import edu.io.token.GoldToken;
import edu.io.token.PyriteToken;
import edu.io.token.Token;

import java.util.Objects;
import java.util.Random;

public class Board {

    public int size = 8;
    public Token[][] grid;

        public Board() {
            this.grid = new Token[size][size];
            clean();
        }

        public void clean(){
            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    grid[i][j] = new EmptyToken();
                }
            }
        }

    public void placeToken(int col, int row, Token token){
        grid[col][row] = token;
    }


    public Token square(int col, int row){
        return grid[col][row];
    }

    public void display(){
        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                Token token = grid[col][row];
                if (token != null) {
                    System.out.printf("%-3s" ,token.label + " ");
                } else {
                    System.out.printf("%-3s" ,"\u30FB");
                }
            }
            System.out.println();
        }
    }

    public void randomlyPlaceToken(int amount, String token) {
        Random random = new Random();

        for (int i = 0; i < amount; i++) {
            // znajdź wolne pole
            int x, y;
            do {
                x = random.nextInt(size);
                y = random.nextInt(size);
            } while (!(peekToken(x, y) instanceof EmptyToken));

            // wstaw token
            if ("gold".equals(token)) {
                placeToken(x, y, new GoldToken());
            } else if ("piryt".equals(token)) {
                placeToken(x, y, new PyriteToken());
            }
        }
    }





    public int size(){

        return size;
    };

    public Token peekToken(int col, int row) {

        return grid[col][row];
    }


    public record Coords(int col, int row){

    }

    public Coords getAvailableSquare() {
        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                if (grid[col][row] instanceof EmptyToken) {
                    return new Coords(col, row);
                }
            }
        }
        throw new IllegalStateException("Plansza jest pelna, nie ma wolnych miejsc");
    }



}
