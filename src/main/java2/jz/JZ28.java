package jz;

import ht_tree.TreeNode;

public class JZ28 {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricHelp(root, root);
    }

    public boolean isSymmetricHelp(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.value != right.value) {
            return false;
        }
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);

    }



}
