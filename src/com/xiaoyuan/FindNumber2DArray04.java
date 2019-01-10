/**
 * @Author: zhengjiayuan
 * @Date: 2019/1/4 11:48
 * @Version 1.0
 */
package com.xiaoyuan;

/**
 * 二维数组的查找
 */
public class FindNumber2DArray04 {

    // 数组按行从左往右递增，按列从上往下递增 时间O(N+M)
    public static boolean FindNumber2DArray(int[][] arr, int target){
        if (arr == null) return false;
        // 取右上角的点
        int i = 0, j = arr[0].length - 1;
        while(i < arr.length && j >= 0){
            if (arr[i][j] ==  target)
                return true;
            if (arr[i][j] >  target)
                j--;
            else
                i++;
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[][] = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };

        System.out.println(FindNumber2DArray(arr, 13));// in between
        System.out.println(FindNumber2DArray(arr, 1)); // in min
        System.out.println(FindNumber2DArray(arr, 15));// in max
        System.out.println(FindNumber2DArray(arr, 5));// out between
        System.out.println(FindNumber2DArray(arr, 0));// out min
        System.out.println(FindNumber2DArray(arr, 16));// out max
        System.out.println(FindNumber2DArray(null, 13));
    }
}
