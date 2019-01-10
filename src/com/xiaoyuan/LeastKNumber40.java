/**
 * @Author: zhengjiayuan
 * @Date: 2019/1/6 11:45
 * @Version 1.0
 */
package com.xiaoyuan;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 最小的k个数
 */
public class LeastKNumber40 {

    /**
     * 利用 partition  时间 o(n) 但会修改数组 todo
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastKNumber1(int[] arr, int k){
        if (arr == null || arr.length < k) return null;
        if (arr.length == k) return arr;
        int start = 0, end = arr.length - 1;
        int index = partition(arr, start, end);
        while (index != k - 1){
            if (index > k - 1)
                end = index - 1;
            else
                start = index + 1;
            index = partition(arr, start, end);
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; i++)
            ret[i] = arr[i];
        return ret;
    }

    private static int partition(int[] arr, int start, int end){
        int i = start, j = end + 1;
        int v = arr[start];
        while (true){
            while (i < end && arr[++i] < v) ;
            while (j > start && arr[--j] > v) ;
            if (i >= j) break;
            swap(arr, i ,j);
        }
        swap(arr, start, j);
        return j;
    }

    private static void swap(int[] arr, int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static class MaxHeapComapartor implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 > o2 ? 1 : -1;
        }
    }

    /**
     * 最大堆实现
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastKNumber2(int[] arr, int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k,new MaxHeapComapartor());

        for (int i = 0; i < arr.length; i++){
            if (maxHeap.size() < k + 1|| maxHeap.peek() > arr[i])
                maxHeap.add(arr[i]);
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; i++)
            ret[i] = maxHeap.poll();
        return ret;
    }


    public static void main(String[] args) {
        int arr[] = {2,5,1,6,4,7,3,8};
        int[] temp = getLeastKNumber1(arr, 4);
        if (temp != null) {
            for (int i = 0; i < temp.length; i++)
                System.out.println(temp[i]);
        }
        temp = getLeastKNumber2(arr, 4);
        if (temp != null) {
            for (int i = 0; i < temp.length; i++)
                System.out.println(temp[i]);
        }
    }
}
