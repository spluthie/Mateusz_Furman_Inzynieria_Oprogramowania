package edu.io;

public class Board {

    public int size;
    public Token[][] grid;

    public Board(int size) {
        this.size = size;
        this.grid = new Token[size][size];
    }

    public void clean(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                grid[i][j] = null;
            }
        }
    }

    public void placeToken(int col, int row, Token token){
        grid[col][row] = token;
    }

    public void square(int col, int row){
        grid = new Token[col][row];
    }

    public void display(){

    }
}
