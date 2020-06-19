package com.guo.algorithm;

import com.guo.AUtils;

import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 算法排序  快排  归并  选择  插入
 */
public class SortDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        //int[] arr = AUtils.getArr(5, 5);
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(arr));
        // 插入排序
        // insertionSort(arr);
        // 选择
        // selectionSort(arr);
        // 快排
        // quickSort(arr, 0, arr.length - 1);
        // 归并
        // mergeSort(arr, 0, arr.length - 1);
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快排
     */
    public static void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int v = arr[l];

        int lt = l;
        int gt = r + 1;
        int i = l + 1;

        while (i < gt) {
            if (arr[i] < v) {
                AUtils.swap(arr, i, lt + 1);
                i++;
                lt++;
            } else if (arr[i] > v) {
                AUtils.swap(arr, i, gt - 1);
                gt--;
            } else {
                i++;
            }
        }
        AUtils.swap(arr, l, lt);
        quickSort(arr, l, lt);
        quickSort(arr, gt, r);
    }

    /**
     * 归并
     */
    public static void mergeSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        if (arr[mid] > arr[mid + 1]) {
            merge(arr, l, mid, r);
        }
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] ar = new int[r - l + 1];
        int i = l;
        int j = mid + 1;

        int k = 0;

        while (i <= mid && j <= r) {
            if (arr[i] < arr[j]) {
                ar[k++] = arr[i++];
            } else {
                ar[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            ar[k++] = arr[i++];
        }
        while (j <= r) {
            ar[k++] = arr[j++];
        }

        for (int m = 0; m < ar.length; m++) {
            arr[m + l] = ar[m];
        }

    }

    /**
     * 选择排序
     */
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int k = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[k] > arr[j]) {
                    k = j;
                }
            }
            AUtils.swap(arr, k, i);
        }
    }

    /**
     * 插入排序
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] < arr[j]) {
                    break;
                }
                AUtils.swap(arr, j - 1, j);
            }
        }
    }

    /**
     *
     */
    public static void heapSort(int[] arr) {
        for (int i = arr.length / 2; i >= 0; i--) {
            shiftUp(i, arr);
        }
    }

    private static void shiftUp(int i, int[] arr) {
        while ((i * 2 + 1) < arr.length) {
            int left = i * 2 + 1;
            if (left + 1 < arr.length && arr[left] < arr[left + 1]) {
                left++;
            }
            if (arr[i] > arr[left]) {
                return;
            }
            AUtils.swap(arr, i, left);
            i = left;
        }
    }
}
