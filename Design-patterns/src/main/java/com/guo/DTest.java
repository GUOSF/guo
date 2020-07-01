package com.guo;

import java.util.Stack;

/**
 * @author gsf
 * @date 2020/6/30 19:04
 */
public class DTest {
    public static void main(String[] args) {
        Stack<String> s = new Stack<>();
        s.push("123");
        s.push("1233");
        System.out.println(s.peek());
        System.out.println(s.pop());
    }
}
