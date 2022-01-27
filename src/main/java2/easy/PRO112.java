package easy;

import ht_tree.TreeNode;

public class PRO112 {
    /*
    空间复杂度：root的高度  O(H)
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.value == targetSum;
        }
        return hasPathSum(root.left, targetSum-root.value) || hasPathSum(root.right, targetSum-root.value);

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        PRO112 p = new PRO112();
        System.out.println(p.hasPathSum(root,26));
    }
}
