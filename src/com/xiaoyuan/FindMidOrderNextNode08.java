/**
 * @Author: zhengjiayuan
 * @Date: 2019/1/4 14:04
 * @Version 1.0
 */
package com.xiaoyuan;

// 寻找以中序遍历的某一个节点的下一个节点
public class FindMidOrderNextNode08 {

    static class Node{
        public int key;
        public Node left;
        public Node right;
        public Node parent;
        Node(int key){
            this.key = key;
        }
    }

    public static Node findMidOrderNextNode(Node node){
        if (node == null)
            return null;
        if (node.right != null){ // 存在右子树， 那么就是他右子树下的最左节点
            Node temp = node.right;
            while (temp.left != null){
                temp = temp.left;
            }
            return temp;
        }else{  // 不存在右子树， 那么就往上找父节点parent0 , 当parent0是它的父节点parent1的左节点 那么parent0存在就是了
            Node p = node;
            while (p.parent != null){
                if (p.parent.left == p)
                    return p.parent;
                p = p.parent;
            }
            return null;
        }
    }


    public static void main(String[] args) {
        Node[] nodes = new Node[10];
        for (int i = 0 ; i < 10; i++){
            nodes[i] = new Node(i);
            nodes[i].left = null;
            nodes[i].right = null;
        }
        Node root = nodes[0];
        root.parent = null;
        root.left = nodes[1];
        root.right = nodes[2];

        nodes[1].parent = root;
        nodes[1].left = nodes[3];
        nodes[1].right = nodes[4];

        nodes[2].parent = root;
        nodes[2].left = nodes[5];
        nodes[2].right = nodes[6];

        nodes[3].parent = nodes[1];
        nodes[3].left = nodes[7];
        nodes[3].right = nodes[8];

        nodes[4].parent = nodes[1];
        nodes[4].left = nodes[9];

        nodes[5].parent = nodes[2];
        nodes[6].parent = nodes[2];
        nodes[7].parent = nodes[3];
        nodes[8].parent = nodes[3];
        nodes[9].parent = nodes[4];

        for (int i = 0 ; i < 10; i++){
            get(nodes[i]);
        }
    }

    public static void get(Node node){
        node = findMidOrderNextNode(node);
        int key = node == null ? -1 : node.key;
        System.out.println(key);
    }
}



