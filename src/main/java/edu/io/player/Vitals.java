package edu.io.player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Vitals {

    private int hydration;

    public Vitals (){
        this.hydration = 100;
        onDeathCallback = () -> {};
    }

    public int hydration(){
        return hydration;
    }
    public void hydrate(int amount){
        if(amount<=0){
            throw new IllegalArgumentException("Ilosc nawodnienia nie moze byc mniejsza od 0");
        }

        hydration += amount;
        if (hydration > 100) {
            hydration = 100;
        }
    }
    public void dehydrate(int amount){
        if(amount<=0){
            throw new IllegalArgumentException("Ilosc odwodnienia nie moze byc mniejsza od 0");
        }

        hydration -= amount;
        if(hydration<=0){
            hydration = 0;
            onDeathCallback.run();
        }

    }
    public boolean isAlive(){
        return hydration > 0;
    }

    public Runnable onDeathCallback;

    public void setOnDeathHandler(@NotNull Runnable callback){
        this.onDeathCallback = Objects.requireNonNull(callback, "callback nie moze byc null");
    }



}
