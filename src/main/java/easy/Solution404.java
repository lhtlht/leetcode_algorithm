package easy;

public class Solution404 {
    /*
    404. 左叶子之和
计算给定二叉树的所有左叶子之和。

示例：

    3
   / \
  9  20
    /  \
   15   7

在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int sumOfLeftLeaves(TreeNode root) {
            return sumLeft(root, false);
        }



    public int sumLeft(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null && isLeft) {
            return root.val;
        } else {
            int left = 0;
            int right = 0;
            if (root.left != null) {
                left = sumLeft(root.left, true);
            }
            if (root.right != null) {
                right = sumLeft(root.right, false);
            }
            return  left + right;
        }
    }


    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        Solution404 s = new Solution404();
        System.out.println(s.sumOfLeftLeaves(head));
    }
}
