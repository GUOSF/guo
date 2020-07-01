package com.guo.strategy.v1;

/**
 * @author gsf
 * @date 2020/6/26 23:36
 */
public interface PayStrategy {
    boolean pay(int paymentAmount);

    void collectPaymentDetails();
}
