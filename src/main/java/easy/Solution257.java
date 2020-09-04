package easy;

import java.util.ArrayList;
import java.util.List;

public class Solution257 {
    /*
    257. 二叉树的所有路径
给定一个二叉树，返回所有从根节点到叶子节点的路径。

说明: 叶子节点是指没有子节点的节点。

示例:

输入:

   1
 /   \
2     3
 \
  5

输出: ["1->2->5", "1->3"]

解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3

     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    List<String> ans;
    public List<String> binaryTreePaths(TreeNode root) {
        ans = new ArrayList<String>();
        if (root == null) {
            return ans;
        }
        String path = "";
        preOrder(root, path);
        return ans;
    }

    public void preOrder(TreeNode node, String path) {
        if (node == null) {
            return;
        }
        path = path + "->" + node.val;
        if (node.left == null && node.right == null) {
            ans.add(path.replaceFirst("->", ""));
        }

        preOrder(node.left, path);
        preOrder(node.right, path);
    }

}
