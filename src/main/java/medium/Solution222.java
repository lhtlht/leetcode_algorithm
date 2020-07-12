package medium;

public class Solution222 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int countNodes(TreeNode root) {
        TreeNode l = root, r = root;
        int lh = 0, rh = 0;
        while (l != null) {
            lh ++;
            l = l.left;
        }
        while (r != null) {
            rh ++;
            r = r.right;
        }

        if (lh == rh) return (int)Math.pow(2, lh) - 1;

        return 1 + countNodes(root.left) + countNodes(root.right);

    }
}
