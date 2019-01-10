/**
 * @Author: zhengjiayuan
 * @Date: 2019/1/4 16:14
 * @Version 1.0
 */
package com.xiaoyuan;

public class Minor2Tree27 {

    static class Node{
        public int key;
        public Node left;
        public Node right;

        Node(int key){
            this.key = key;
        }
    }

    public static Node getMinor2Tree(Node node){
        if (node == null)
            return null;
        Node temp = node.left;
        node.left = getMinor2Tree(node.right);
        node.right = getMinor2Tree(temp);
        return node;
    }

    public static void lastOrder(Node node){
        if (node == null)
            return;
        lastOrder(node.left);
        lastOrder(node.right);
        System.out.print(node.key + "  ");
    }

    public static void main(String[] args) {
        Node[] nodes = new Node[7];
        for (int i = 0 ; i < 7; i++){
            nodes[i] = new Node(i);
            nodes[i].left = null;
            nodes[i].right = null;
        }

        Node root = nodes[0];

        root.left = nodes[1];
        root.right = nodes[2];

        nodes[1].left = nodes[3];
        nodes[1].right = nodes[4];

        nodes[2].left = nodes[5];
        nodes[2].right = nodes[6];
        lastOrder(root);
        System.out.println();
        root = getMinor2Tree(root);
        lastOrder(root);
    }
}
