package edu.io.player;

import edu.io.token.*;

public class Player {

    public final Gold gold = new Gold();
    private double goldAmount = 0;
    private PlayerToken assignedToken;
    private Token pickaxeToken = new EmptyToken();
    private Shed shed = new Shed();
    public Vitals vitals = new Vitals();


    public Player() {

    }


    public void assignToken(PlayerToken token){
        if(token == null) throw new NullPointerException("Token nie może być null");

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

        gold.gain(amount);
    }


    public void loseGold(double amount){

        if(goldAmount-amount<0||amount<0){
            throw new IllegalArgumentException("Ilosc zlota nie moze byc nagatywna");
        }
        goldAmount -= amount;

    }


    public void interactWithToken(Token token) {

        if(token==null){
            throw new NullPointerException("token nie moze byc null");
        }
        if(!vitals.isAlive()){
            throw new IllegalStateException("gostek nie zyje");
        }
        if (token instanceof GoldToken goldToken) {
            System.out.println("GOLD GOLD GOLD!");
            double amount = goldToken.amount();

            vitals.dehydrate(VitalsValues.DEHYDRATION_GOLD);

            Tool tool = shed.getTool();

            if (tool instanceof PickaxeToken pickaxe) {
                pickaxe.useWith(goldToken)
                        .ifWorking(() -> {
                            gainGold(amount * pickaxe.gainFactor());
                            System.out.println("Zdobyles " + amount * pickaxe.gainFactor() + " zlota");
                        })

                        .ifBroken(() -> {
                            gainGold(amount);
                            pickaxeToken = new EmptyToken();
                            System.out.println("Zdobyles " + amount + " zlota");
                        })
                        .ifIdle(() -> {
                            gainGold(amount);
                            System.out.println("Zdobyles " + amount + " zlota");
                        });


            } else {
                gainGold(amount);
                System.out.println("Zdobyles " + amount + " zlota");
            }

        } else if (token instanceof PickaxeToken newPickaxe) {
            this.pickaxeToken = newPickaxe;
            shed.add(newPickaxe);


        } else if (token instanceof AnvilToken) {
            Tool tool = shed.getTool();
            vitals.dehydrate(VitalsValues.DEHYDRATION_ANVIL);

            if (tool instanceof Repairable repairable) {
                repairable.repair();
            }

        }
        else if(token instanceof WaterToken water){
            vitals.hydrate(water.amount());
        }
        else{
            vitals.dehydrate(VitalsValues.DEHYDRATION_MOVE);
        }

    }

}
