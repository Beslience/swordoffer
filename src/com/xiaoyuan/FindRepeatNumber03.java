/**
 * @Author: zhengjiayuan
 * @Date: 2019/1/4 11:07
 * @Version 1.0
 */
package com.xiaoyuan;

/**
 * 数组中重复的数字
 */
public class FindRepeatNumber03 {

    /**
     * 时间 O(n) 空间O(1)
     * @param arr
     * @return
     */
    public static int FindRepeatNumber1(Integer[] arr){
        if (arr == null || arr.length == 1) return -1;
        int temp = 0;
        for (int i = 0; i < arr.length; i++){
            // 由于n长度 都在 0~n-1中 可以修改数组是对应下标下有对应的数字
            // 先判断i下标是否是对应的数字, 是的话就下一个下标
            while(arr[i] != i){
                if(arr[arr[i]] != arr[i]){ // 当i下标下的数字a 与 以数字a为下标的数相等时返回 重复的数
                    temp = arr[arr[i]]; // 不相等时，交换两个下标的数，继续判断i下标的数
                    arr[arr[i]] = arr[i];
                    arr[i] = temp;
                }else
                    return arr[i];
            }
        }
        return -1;
    }

    /**
     * 不可以修改数组长度n+1 1~n 必定存在一个数字重复 O(n) O(1) M
     * @param arr
     * @return
     */
    public static int FindRepeatNumber2(int[] arr){
        if (arr == null) return -1;
        if (arr.length == 2) return 1;
        int start = 1, end = arr.length - 1;
        while(start < end){
            int mid = (end - start) / 2 + start;
            int leftNum = 0, rightNum = 0;
            for (int i = 0; i < arr.length; i++){
                if (arr[i] <= mid)
                    leftNum++;
                else
                    rightNum++;
            }
            if (leftNum > mid - start + 1 ){
                if (mid == start)
                    return start;
                end = mid;
            } else if(rightNum > end - mid + 1 + 1){
                if (end == mid + 1)
                    return end;
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] arr = {2, 3, 1, 0, 2, 5, 3};
        Integer[] arr1 = {0, 1, 2, 3, 4, 5};
        System.out.println(FindRepeatNumber1(arr));
        System.out.println(FindRepeatNumber1(arr1));
        System.out.println(FindRepeatNumber1(null));

        System.out.println("------------------------");
        int arr2[] = {2,3,5,4,3,2,6,7};
        System.out.println(FindRepeatNumber2(arr2));
    }
}
