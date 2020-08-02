package medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution116 {
    /*
    116. 填充每个节点的下一个右侧节点指针
给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

初始状态下，所有 next 指针都被设置为 NULL。
     */
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        int height = 0;
        int index = 0;
        Node pre = root;
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (index == Math.pow(2,height)-1) {
                pre.next = null;
                height ++;
                index ++;
            } else{
                pre.next = curr;
                index++;
            }
            pre = curr;
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }


        }

        return root;
    }

    public void order(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node p = queue.poll();
            if (p.next != null) {
                System.out.println(p.val + " " + p.next.val);
            } else {
                System.out.println(p.val + " " + p.next);
            }
            if (p.left != null) queue.add(p.left);
            if (p.right != null) queue.add(p.right);
        }
    }
    public static void main(String[] args) {
        Node p4 = new Node(4, null, null, null);
        Node p5 = new Node(5, null, null, null);
        Node p6 = new Node(6, null, null, null);
        Node p7 = new Node(7, null, null, null);


        Node p2 = new Node(2, p4, p5, null);
        Node p3 = new Node(3, p6, p7, null);
        Node p1 = new Node(1, p2, p3, null);

        Solution116 s = new Solution116();
        Node res = s.connect(p1);
        s.order(p1);
        System.out.println("-----------------------------------------");
        s.order(res);
    }

}
