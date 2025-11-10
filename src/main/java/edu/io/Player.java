package edu.io;

import edu.io.token.GoldToken;
import edu.io.token.PlayerToken;
import edu.io.token.Token;

public class Player {

    private double goldAmount = 0;
    private PlayerToken assignedToken;


    public Player() {

    }
    


    public void assignToken(PlayerToken token){
        if(token == null) throw new IllegalArgumentException("Token nie może być null");

        this.assignedToken = token;
    }


    public PlayerToken token(){
        return assignedToken;
    }

    public double gold(){

        return goldAmount;
    }

    public void gainGold(double amount){
        if(amount<0){
            throw new IllegalArgumentException("Ilosc zlota nie moze byc nagatywna");
        }
        goldAmount += amount;
    }

    public void loseGold(double amount){

        if(goldAmount-amount<0||amount<0){
            throw new IllegalArgumentException("Ilosc zlota nie moze byc nagatywna");
        }
        goldAmount -= amount;

    }


    public void interactWithToken(Token token) {
        if(token instanceof GoldToken gold){
            gainGold(gold.amount());
        }
    }



}
