package easy;

public class Solution563 {
    /*
    563. 二叉树的坡度
给定一个二叉树，计算整个树的坡度。

一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。

整个树的坡度就是其所有节点的坡度之和。
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int ans = 0;
    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        lrdiff(root);
        return ans;
    }

    public int lrdiff(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = lrdiff(node.left);
        int right = lrdiff(node.right);
        ans += Math.abs(left-right);
        return node.val + left + right;
    }
}
