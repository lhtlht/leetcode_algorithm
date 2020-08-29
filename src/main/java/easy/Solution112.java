package easy;

public class Solution112 {
    /*
    112. 路径总和
    给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

    说明: 叶子节点是指没有子节点的节点。

    示例:
    给定如下二叉树，以及目标和 sum = 22，

                  5
                 / \
                4   8
               /   / \
              11  13  4
             /  \      \
            7    2      1
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    boolean ans;
    public boolean hasPathSum(TreeNode root, int sum) {
        ans = false;
        dfs(root, 0, sum);
        return ans;
    }

    public void dfs(TreeNode root, int currSum, int sum) {
        if (root == null) {
            return;
        }
        currSum += root.val;
        if (root.left == null && root.right == null) {
            if (currSum == sum) {
                ans = true;
            }
            return;
        }
        dfs(root.left, currSum, sum);
        dfs(root.right, currSum, sum);
    }

    public static void main(String[] args) {
        Solution112 s = new Solution112();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        System.out.println(s.hasPathSum(root, 222));

    }

}
