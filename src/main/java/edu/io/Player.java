package edu.io;

public class Player {
    private int x;
    private int y;
    private int goldCollected;

    public Player(int startX, int startY) {
        this.x = startX;
        this.y = startY;
        this.goldCollected = 0;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getGoldCollected() { return goldCollected; }

    public void move(int dx, int dy, int boardSize) {
        int newX = x + dx;
        int newY = y + dy;

        if (newX >= 0 && newX < boardSize && newY >= 0 && newY < boardSize) {
            x = newX;
            y = newY;
        }
    }

    public void collectGold() {
        goldCollected++;
    }
}
