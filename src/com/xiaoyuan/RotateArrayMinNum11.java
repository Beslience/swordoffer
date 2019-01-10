/**
 * @Author: zhengjiayuan
 * @Date: 2019/1/5 0:06
 * @Version 1.0
 */
package com.xiaoyuan;

/**
 * 查找一个递增数组被旋转后的最小值
 */
public class RotateArrayMinNum11 {

    public static int findRotateArrayMinNum(int[] arr){
        if (arr == null)   return - 1;

        int start = 0, end = arr.length - 1;
        while (start < end){
            int mid = (end - start) / 2 + start;
            if (arr[mid] < arr[end]) {
                if (end - mid == 1)
                    return arr[mid];
                end = mid;
            }
            else if(arr[mid] > arr[start]) {
                if (mid - start == 1)
                    return arr[mid];
                start = mid;
            }
            else{
                int min = arr[0];
                for (int i = 1; i < arr.length; i++)
                    min = arr[i] < min ? arr[i] : min;
                return min;
            }
        }
        return  -1;
    }

    public static void main(String[] args) {
        int arr[] = {3,4,5,1,2};
        System.out.println(findRotateArrayMinNum(arr));
        int arr1[] = {2,0,2,2,2,2};
        System.out.println(findRotateArrayMinNum(arr1));

        System.out.println(findRotateArrayMinNum(new int[]{5}));
        System.out.println(findRotateArrayMinNum(null));
    }
}
