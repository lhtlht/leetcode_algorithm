package jz;

import ht_tree.TreeNode;

public class JZ68I {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if(ancestor.value < p.value && ancestor.value < q.value) {
                ancestor = ancestor.right;
            } else if (ancestor.value > p.value && ancestor.value > q.value) {
                ancestor = ancestor.left;
            } else {
                break;
            }

        }
        return ancestor;
    }


}
