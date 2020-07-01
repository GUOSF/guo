package com.guo;

/**
 * 爬楼梯
 *
 * @author gsf
 * @date 2020/6/23 23:27
 */
public class LC70 {
    static int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int f1 = 1, f2 = 2, f3 = 3;
        for (int i = 1; i <= n; ++i) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }

    public static void main(String[] args) {

        int i = climbStairs(5);
        System.out.println(i);
    }
}
