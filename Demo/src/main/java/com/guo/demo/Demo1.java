package com.guo.demo;

import java.util.HashMap;
import java.util.Map;

public class Demo1 {
    public static void main(String[] args) {
        String s= "b";
        String ss= new  String ("b");

        Map map = new HashMap();
        map.put(1,1);
        String s1 = s.intern();
        String ss1 = ss.intern();
        System.out.println(s1==s);
        System.out.println(ss1==ss);
        System.out.println(ss1==s);
        System.out.println(ss1==s1);
        System.out.println(ss1.equals(ss));
        System.out.println(s.equals(ss));

    }
}
