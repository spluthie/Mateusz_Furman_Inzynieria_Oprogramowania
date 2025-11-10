package edu.io.player;

public class Gold {

    private double amount;

    public Gold(){
        amount = 0;
    }


    public Gold(double amount){
        if(amount < 0){
            throw new IllegalArgumentException();
        }
        this.amount = amount;
    }


    public double amount(){
        return amount;
    }


    public void gain(double amount){
        if(amount >= 0){
            this.amount += amount;
        }
        else{
            throw new IllegalArgumentException();
        }


    }


    public void lose(double amount){
        if(amount >= 0){
            if(this.amount-amount < 0){
                throw new IllegalArgumentException();
            }
            this.amount -= amount;

        }
        else{
            throw new IllegalArgumentException();
        }

    }

}
