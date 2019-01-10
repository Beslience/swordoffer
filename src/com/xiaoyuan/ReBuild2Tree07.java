/**
 * @Author: zhengjiayuan
 * @Date: 2019/1/4 13:15
 * @Version 1.0
 */
package com.xiaoyuan;

// 根据先序遍历和中序遍历重建二叉树
public class ReBuild2Tree07 {

    static class Node{
        public int key;
        public Node left;
        public Node right;
        Node(int key){
            this.key = key;
        }
    }

    public static Node reBuild2Tree(int[] firstorder,int[] midorder, int fstart, int fend, int mstart,int midend){
        if (fstart > fend || mstart > midend || (fend - fstart) != (midend - mstart))
            return null;
        int i = mstart;
        for (; i < midend; i++) {
            if (midorder[i] == firstorder[fstart])
                break;
        }
        Node root = new Node(firstorder[fstart]);
        int lmstart = mstart, lmend = i - 1, lfstart = fstart + 1,lfend = lfstart + (lmend - lmstart);
        int rmstart = i + 1, rmend = midend, rfstart = lfend + 1,rfend = fend;
        root.left = reBuild2Tree(firstorder, midorder, lfstart, lfend, lmstart,lmend);
        root.right = reBuild2Tree(firstorder, midorder, rfstart, rfend, rmstart, rmend);
        return root;
    }

    public static void lastOrder(Node node){
        if (node == null)
            return;
        lastOrder(node.left);
        lastOrder(node.right);
        System.out.print(node.key + "  ");
    }


    public static void main(String[] args) {
        int[] firstorder = {1, 2, 4, 7, 3 ,5, 6, 8};
        int[] midorder = {4, 7, 2, 1, 5, 3, 8, 6};
        int len = firstorder.length;
        Node node = reBuild2Tree(firstorder, midorder, 0 ,len, 0,len);
        lastOrder(node);
    }
}
