package com.guo.strategy.v3;


import com.guo.strategy.v3.payport.PayStrategy;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        Order order = new Order("1","2020031401000323",324.5);
        System.out.println(order.pay(PayStrategy.UNION_PAY));
    }
}
