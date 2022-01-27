package easy;

import ht_tree.TreeNode;

public class PRO226 {
    public TreeNode invertTree(TreeNode root) {
        invertSonTree(root);
        return root;
    }

    public void invertSonTree(TreeNode node) {
        if (node != null) {
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            invertSonTree(node.left);
            invertSonTree(node.right);
        }
    }
}
