package edu.io.token;

public class GoldToken extends Token {


    public double amount;


    public GoldToken(){
        super(Label.GOLD_TOKEN_LABEL);
        amount = 1;
    }


    public GoldToken(double amount){
        super(Label.GOLD_TOKEN_LABEL);

        if(amount<0){
            throw new IllegalArgumentException("Zloto nie moze miec negatywnej wartosci");
        }
        this.amount = amount;

    }

    
    public double amount(){
        return amount;
    }

}
