package medium;

import java.util.Stack;

public class Solution230 {
    /*
    230. 二叉搜索树中第K小的元素
给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。

说明：
你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        //方法1，栈遍历
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        int count = 0;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            count ++;
            System.out.println(count);
            if (count == k) {
                return curr.val;
            }
            curr = curr.right;
        }
        return 1;
    }

    int count = 0;
    int res = 0;
    public int kthSmallest2(TreeNode root, int k) {
        //方法2，递归遍历
        inorder(root,k);
        return res;
    }

    public void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        inorder(root.left, k);
        count ++;
        if (count == k) {
            res = root.val;
        }
        inorder(root.right, k);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        Solution230 s = new Solution230();
        System.out.println(s.kthSmallest2(root, 3));
    }

}
