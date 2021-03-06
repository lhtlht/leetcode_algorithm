package easy;

public class Solution687 {
    /*
    687. 最长同值路径
    给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。

    注意：两个节点之间的路径长度由它们之间的边数表示。

    示例 1:

    输入:

                  5
                 / \
                4   5
               / \   \
              1   1   5
    输出:

    2
    示例 2:

    输入:

                  1
                 / \
                4   5
               / \   \
              4   4   5
    输出:

    2
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        maxValue(root);
        return ans;
    }

    public int maxValue(TreeNode node) {
        if (node == null) return 0;
        int left = maxValue(node.left);
        int right = maxValue(node.right);
        int currLeft = 0;
        int currRight = 0;
        if (node.left != null && node.left.val == node.val) {
            currLeft += left+1;
        }
        if (node.right != null && node.right.val == node.val) {
            currRight += right+1;
        }
        ans = Math.max(ans, currLeft+currRight);
        return Math.max(currLeft, currRight);

    }
}
