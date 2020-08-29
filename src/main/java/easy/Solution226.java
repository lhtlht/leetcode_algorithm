package easy;

public class Solution226 {
    /*
    226. 翻转二叉树
    翻转一棵二叉树。

    示例：

    输入：

         4
       /   \
      2     7
     / \   / \
    1   3 6   9
    输出：

         4
       /   \
      7     2
     / \   / \
    9   6 3   1
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
        dfs(node.left);
        dfs(node.right);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(7);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(1);
        Solution226 s = new Solution226();
        s.invertTree(root);
    }
}
