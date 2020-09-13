package easy;

import java.util.*;

public class Solution107 {
    /*
    107. 二叉树的层次遍历 II
    给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

    例如：
    给定二叉树 [3,9,20,null,null,15,7],

        3
       / \
      9  20
        /  \
       15   7
    返回其自底向上的层次遍历为：

    [
      [15,7],
      [9,20],
      [3]
    ]
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<Integer>();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.addFirst(new ArrayList<Integer>(level));
        }

        return res;
    }


    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
        if (root == null) {
            return res;
        }
        dfs(root, res, 1);
        Collections.reverse(res);
        return res;
    }

    public void dfs(TreeNode root, LinkedList<List<Integer>> res , int index) {
        if (root == null) {
            return;
        }
        if (index > res.size()) {
            res.add(new ArrayList<Integer>());
        }
        res.get(index-1).add(root.val);
        dfs(root.left, res, index+1);
        dfs(root.right, res, index+1);

    }
}
