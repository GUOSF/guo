package com.guo.strategy.v2;

/**
 * Created by Tom.
 */
public class GroupbuyStrategy implements IPromotionStrategy {
    public void doPromotion() {
        System.out.println("5人成团，可以优惠");
    }
}
