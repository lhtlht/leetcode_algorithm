package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution94 {
    /*
    94. 二叉树的中序遍历
    给定一个二叉树，返回它的中序 遍历。

    示例:

    输入: [1,null,2,3]
       1
        \
         2
        /
       3

    输出: [1,3,2]
    进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
}
    //递归解法
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null){
            return ;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }


    //迭代栈中序遍历
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }

        return res;
    }

}
