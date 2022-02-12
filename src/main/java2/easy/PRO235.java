package easy;

import ht_tree.TreeNode;

public class PRO235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.value-p.value)*(root.value*q.value)>0) { //同大于根或者同小于根
            root = root.value>p.value?root.left:root.right;
        }
        return root;
    }
}
