package medium;

public class Solution156 {
    /*
    156. 上下翻转二叉树
    给定一个二叉树，其中所有的右节点要么是具有兄弟节点（拥有相同父节点的左节点）的叶节点，要么为空，将此二叉树上下翻转并将它变成一棵树， 原来的右节点将转换成左叶节点。返回新的根。

    例子:

    输入: [1,2,3,4,5]

        1
       / \
      2   3
     / \
    4   5

    输出: 返回二叉树的根 [4,5,2,#,#,3,1]

       4
      / \
     5   2
        / \
       3   1
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    TreeNode res;
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        order(root);
        return res;
    }

    public TreeNode order(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.left == null && node.right == null) {
            if (res == null) {
                res = node;
            }
            return node;
        }
        TreeNode left = order(node.left);
        TreeNode right = order(node.right);
        if (left != null) {
            left.left = right;
            left.right = node;
        }

        node.left = null;
        node.right = null;
        return node;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        Solution156 s = new Solution156();
        s.upsideDownBinaryTree(root);
    }
}
