package easy;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Solution671 {
    /*
    671. 二叉树中第二小的节点
给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。

给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。

示例 1:

输入:
    2
   / \
  2   5
     / \
    5   7

输出: 5
说明: 最小的值是 2 ，第二小的值是 5 。
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int min = Integer.MAX_VALUE;
    int min2 = Integer.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        //根节点是最小的值
        if (root == null) {
            return -1;
        }
        return findMin(root, root.val);

    }

    public int findMin(TreeNode node, int val) {
        if (node == null) {
            return -1;
        }
        if (node.val > val) {
            return node.val;
        }
        int l = findMin(node.left, val);
        int r = findMin(node.right, val);
        if (l > val && r > val) {
            return Math.min(l,r);
        }
        return Math.max(l,r);


    }

    public void dfs(TreeNode node) {

    }
}
