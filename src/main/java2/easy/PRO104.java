package easy;

import ht_tree.TreeNode;

import static java.lang.Math.max;

public class PRO104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }

    public static void main(String[] args) {
        PRO104 p = new PRO104();
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(8);

        System.out.println(p.maxDepth(root));
    }
}
