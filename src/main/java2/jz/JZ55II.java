package jz;

import ht_tree.TreeNode;

public class JZ55II {
    boolean res;
    public boolean isBalanced(TreeNode root) {
        res = true;
        high(root);
        return res;

    }

    public int high(TreeNode node) {
        if(node == null) return 0;
        int lh = high(node.left)+1;
        int rh = high(node.right)+1;
        if(Math.abs(lh - rh) > 1) {
            res = false;
        }
        return Math.max(lh, rh);
    }
}
