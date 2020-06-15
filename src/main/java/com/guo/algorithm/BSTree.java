package com.guo.algorithm;

import java.util.HashMap;
import java.util.Map;

public class BSTree {


    public static void main(String[] args) {
        Node node = new Node(1, 2);
        Node node1 = new Node(3, 4);
        Node node2 = new Node(5, 6);
        node.setLeft(node1);
        node.setRight(node2);
        inOrder(node);
        System.out.println(node);


        Map map = new HashMap();
        map.put(null, 123);
        System.out.println(map.get(null));

    }

    private static void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.getLeft());
        inOrder(node.getRight());
        System.out.println(node.getKey() + " " + node.getValue());
    }
}
