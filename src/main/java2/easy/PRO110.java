package easy;

import ht_tree.TreeNode;

import static java.lang.Math.abs;
import static java.lang.Math.max;

public class PRO110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return abs(left-right)<=1 && isBalanced(root.left) && isBalanced(root.right);

    }
    public int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return max(treeDepth(root.left)+1, treeDepth(root.right)+1);
    }
}
