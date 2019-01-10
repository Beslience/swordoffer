/**
 * @Author: zhengjiayuan
 * @Date: 2019/1/5 0:57
 * @Version 1.0
 */
package com.xiaoyuan;

// 剪绳子 是每一段总乘积最大 TODO 动态规划 到时再看是视频吧
public class Cut14 {

    public static int cut(int len){
        if (len <= 2) return len;
        int[] arr = new int[len - 2 + 1];
        int j = 0;
        for (int i = 2; i < len; i++){
            arr[j] = i * cut(len - i);
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++)
            max = max < arr[i] ? arr[i] : max;
        return max;
    }

    public static void main(String[] args) {
        System.out.println(cut(10));
    }
}
