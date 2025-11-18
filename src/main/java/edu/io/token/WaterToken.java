package edu.io.token;

public class WaterToken extends Token{

    private int amount;

    public WaterToken(){
        super(Label.WATER_TOKEN_LABEL);
        amount = 10;
    }
    public WaterToken(int amount){
        super(Label.WATER_TOKEN_LABEL);
        if(amount>100||amount<0){
            throw new IllegalArgumentException("Ilosc wody nie moze byc mniejsza od 0 lub wieksza od 100");
        }
        this.amount = amount;
    }

    public int amount(){
        return amount;
    }

}
