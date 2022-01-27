package jz;

import ht_tree.TreeNode;

public class JZ27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return root;
        printTree(root);
        return root;
    }

    public void printTree(TreeNode node) {
        if (node != null) {
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            printTree(node.left);
            printTree(node.right);
        }
    }

}
