package jianzhi_offer;

public class Solution27 {
    /*
    剑指 Offer 27. 二叉树的镜像
    请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        TreeNode tmp = left;
        root.left = right;
        root.right = tmp;
        return root;
    }

    public void dfs(TreeNode node) {

    }

    public static void main(String[] args) {

    }
}
