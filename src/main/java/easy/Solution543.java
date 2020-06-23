package easy;

import ht_tree.TreeNode;

public class Solution543 {
    /**
     * 543. 二叉树的直径
     * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
     */
    int ansMax = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ansMax;
    }


    public int dfs(TreeNode root){
        if (root == null ) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        ansMax = Math.max(left+right, ansMax);
        return Math.max(left, right)+1;

    }
}
