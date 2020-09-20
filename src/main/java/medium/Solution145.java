package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution145 {
    /*
    145. 二叉树的后序遍历
    给定一个二叉树，返回它的 后序 遍历。

    示例:

    输入: [1,null,2,3]
       1
        \
         2
        /
       3

    输出: [3,2,1]
    进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     */
    public class TreeNode {
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

    List<Integer> ans;
    public List<Integer> postorderTraversal(TreeNode root) {
        ans = new ArrayList<Integer>();
        backOrder(root);
        return ans;
    }

    public void backOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        backOrder(node.left);
        backOrder(node.right);
        ans.add(node.val);
    }


    public List<Integer> postorderTraversal2(TreeNode root) {
        //非递归
        //从下到上，从左到右
        LinkedList<Integer> ans = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null) return ans;
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            ans.addFirst(cur.val);
            if (cur.left != null) {
                stack.add(cur.left);
            }
            if (cur.right != null) {
                stack.add(cur.right);
            }
        }
        return ans;
    }
}
