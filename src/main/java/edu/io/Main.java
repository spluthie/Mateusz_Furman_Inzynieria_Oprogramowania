package edu.io;

public class Main {
    public static void main(String[] args) {
        System.out.println("Gold Rush");
        Board plansza = new Board();

        Token pustePole = new Token("\u30FB");
        Token worekKasy = new Token("\uD83D\uDCB0");
        Token gracz = new Token("\uC6C3");


        plansza.placeToken(5, 5, gracz);
        plansza.placeToken(7, 6, worekKasy);

        plansza.square(7, 6);
        plansza.display();
    }

}
