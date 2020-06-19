package com.guo.decorator.Battercake.v2;

/**
 * Created by Tom.
 */
public class BattercakeDecorator implements Battercake{


    private Battercake battercake;

    public BattercakeDecorator(Battercake battercake) {
        this.battercake = battercake;
    }

    public String getMsg(){ return this.battercake.getMsg();}

    public int getPrice(){ return this.battercake.getPrice();}

}
