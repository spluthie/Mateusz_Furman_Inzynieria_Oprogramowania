package edu.io;

public class Board {

    public int size = 8;
    public Token[][] grid;

    public Board() {
        this.grid = new Token[size][size];

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                grid[i][j] = new Token("\u30FB");
            }
        }
    }

    public void clean(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                grid[i][j] = new Token("\u30FB");
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
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
