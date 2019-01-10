/**
 * @Author: zhengjiayuan
 * @Date: 2019/1/4 14:48
 * @Version 1.0
 */
package com.xiaoyuan;

import java.util.Stack;

/**
 * 用两个栈实现队列
 */
public class StackToQueue09<T> {

    private Stack<T> save;
    private Stack<T> help;

    StackToQueue09(){
        save = new Stack<>();
        help = new Stack<>();
    }

    public void offer(T item){
        while (!save.isEmpty())
            help.push(save.pop());
        help.push(item);
        while (!help.empty())
            save.push(help.pop());
    }

    public T poll(){
        if (isEmpty())
            return null;
        return save.pop();
    }

    public boolean isEmpty(){
        return save.empty();
    }

    public static void main(String[] args) {
        StackToQueue09<Integer> queue = new StackToQueue09<>();
        queue.offer(0);
        queue.offer(1);
        queue.offer(2);
        System.out.println(queue.poll());
        queue.offer(3);
        queue.offer(5);
        queue.offer(4);
        queue.offer(6);
        while (!queue.isEmpty())
            System.out.println(queue.poll());
    }
}
