package com.guo;

import java.util.Random;

/**
 * @author shufeng.guo
 * @date 2019-04-07 08:17
 */
public class AUtils {
    public static void swap(int[] arr, int i, int j) {
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }


    public static int[] getArr(int n) {
        return getArr(n, n);
    }

    public static int[] getArr(int n, int m) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Random().nextInt(m);
        }
        return arr;
    }

    public static void main(String[] args) {

    }
}
