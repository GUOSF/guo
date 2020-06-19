package com.guo.decorator.Battercake.v2;

/**
 * Created by Tom.
 */
public class EggDecorator extends BattercakeDecorator{

    public EggDecorator(Battercake battercake) {
        super(battercake);
    }

    public String getMsg(){ return super.getMsg() + "1个鸡蛋";}

    public int getPrice(){ return super.getPrice() + 1;}

}
