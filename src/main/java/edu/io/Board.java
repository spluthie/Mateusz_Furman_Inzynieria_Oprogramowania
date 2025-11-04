package edu.io;

import edu.io.token.EmptyToken;
import edu.io.token.GoldToken;
import edu.io.token.Token;

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
        grid[row][col] = token;
    }


    public Token square(int col, int row){
        return grid[row][col];
    }

    public void display(){
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                Token token = grid[col][row];
                if (token != null) {
                    System.out.print(token.label + " ");
                } else {
                    System.out.print("\u30FB");
                }
            }
            System.out.println();
        }
    }

    public void randomlyPlaceGold(int amount) {
        Random random = new Random();
        for (int i = 0; i <= amount; i++) {
            int x = random.nextInt(size);
            int y = random.nextInt(size);
            placeToken(x, y, new GoldToken());
        }
    }

    public void removeGoldAt(int x, int y) {
        placeToken(x, y, new EmptyToken());
    }


    public int size(){

        return size;
    };

    public Token peekToken(int col, int row) {

        return grid[row][col];
    }


    public record Coords(int col, int row){

    }

}
