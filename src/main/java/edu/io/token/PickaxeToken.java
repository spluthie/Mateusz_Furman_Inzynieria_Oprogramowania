package edu.io.token;

import edu.io.player.Repairable;
import edu.io.player.Tool;

public class PickaxeToken extends Token implements Tool, Repairable {


    private boolean used = false;
    private double gainFactor;
    private int durability;
    private int maxDurability;

    public PickaxeToken(){
        super(Label.PICKAXE_TOKEN_LABEL);
        gainFactor = 1.5;
        durability = 3;
        maxDurability = 3;
    }
    public PickaxeToken(double gainFact){
        super(Label.PICKAXE_TOKEN_LABEL);
        if(gainFact<=0){
            throw new IllegalArgumentException();
        }
        gainFactor = gainFact;
        durability = 3;
        maxDurability = 3;
    }
    public PickaxeToken(double gainFact, int durabilityStat){
        super(Label.PICKAXE_TOKEN_LABEL);
        gainFactor = gainFact;
        if(durabilityStat<=0){
            throw new IllegalArgumentException();
        }
        durability = durabilityStat;
        maxDurability = durabilityStat;
    }

    public double gainFactor(){
        return gainFactor;
    }

    public int durability(){
        return durability;
    }

    public void use(){
        durability--;
    }

    @Override
    public boolean isBroken(){
        return durability <= 0;
    }

    @Override
    public PickaxeToken useWith(Token token) {
        used = false;
        if (token instanceof GoldToken) {
            used = true;
            use();
        }
        return this;
    }


    @Override
    public PickaxeToken ifWorking(Runnable action) {
        if (used && !isBroken()) action.run();
        return this;
    }

    @Override
    public PickaxeToken ifBroken(Runnable action) {
        if (isBroken()) action.run();
        return this;
    }

    @Override
    public PickaxeToken ifIdle(Runnable action) {
        if (!used && !isBroken()) action.run();
        return this;
    }

    @Override
    public void repair(){
        durability = maxDurability;
    }

}
