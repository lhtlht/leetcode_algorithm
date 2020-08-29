package medium;

import java.util.LinkedList;
import java.util.List;

public class Solution144 {
    /*
    144. 二叉树的前序遍历
    给定一个二叉树，返回它的 前序 遍历。

     示例:

    输入: [1,null,2,3]
       1
        \
         2
        /
       3

    输出: [1,2,3]
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    List<Integer> ans;
    public List<Integer> preorderTraversal(TreeNode root) {
        ans = new LinkedList<Integer>();
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }

}
