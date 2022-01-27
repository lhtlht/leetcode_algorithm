package easy;

import ht_tree.TreeNode;

public class PRO617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode res = merge(root1,root2);
        return res;
    }

    public TreeNode merge(TreeNode n1, TreeNode n2) {
        if (n2 == null) {
            return n1;
        }
        if (n1 == null) {
            n1 = n2;
        } else {
            n1.value += n2.value;

            n1.left = merge(n1.left, n2.left);
            n1.right = merge(n1.right, n2.right);
        }
        return n1;
    }

}
