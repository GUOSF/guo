package com.guo;

/**
 * 盛最多水的容器
 *
 * @author gsf
 * @date 2020/6/23 23:27
 */
public class LC11 {
    public static void main(String[] args) {
        int[] ar = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int i = maxArea(ar);
        System.out.println(i);
    }

    public static int maxArea(int[] height) {
        int ans = 0, l = 0, r = height.length - 1;
        while (l < r) {
            int h = height[l] <= height[r] ? height[l++] : height[r--];
            ans = Math.max(ans, h * (r - l + 1));
        }
        return ans;
    }
}
