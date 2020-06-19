package com.guo.decorator.Battercake.v2;

/**
 * Created by Tom.
 */
public class SauageDecorator extends BattercakeDecorator{

    public SauageDecorator(Battercake battercake) {
        super(battercake);
    }

    public String getMsg(){ return super.getMsg() + "1根香肠";}

    public int getPrice(){ return super.getPrice() + 2;}

}
