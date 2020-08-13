package jianzhi_offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution34 {
    /*
    剑指 Offer 34. 二叉树中和为某一值的路径
    输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。



    示例:
    给定如下二叉树，以及目标和 sum = 22，

                  5
                 / \
                4   8
               /   / \
              11  13  4
             /  \    / \
            7    2  5   1
    返回:

    [
       [5,4,11,2],
       [5,8,4,5]
    ]
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return res;
        }
        LinkedList<Integer> tmp = new LinkedList<Integer>();
        int tmpSum = root.val;
        tmp.add(root.val);
        dfs(root, tmp, tmpSum, sum);
        return res;
    }

    public void dfs(TreeNode root, LinkedList<Integer> tmp, int tmpSum, int sum) {
        if (root.left == null && root.right == null) {
            if (tmpSum == sum) {
                res.add(new ArrayList<Integer>(tmp));
            }
            return;
        }
        if (tmpSum >= sum ) {
            return;
        }
        if (root.left != null) {
            tmpSum += root.left.val;
            tmp.add(root.left.val);
            dfs(root.left, tmp, tmpSum, sum);
            tmpSum -= root.left.val;
            tmp.removeLast();
        }

        if (root.right != null) {
            tmpSum += root.right.val;
            tmp.add(root.right.val);
            dfs(root.right, tmp, tmpSum, sum);
            tmpSum -= root.right.val;
            tmp.removeLast();
        }
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
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        Solution34 s = new Solution34();
        System.out.println(s.pathSum(root, 22));

    }
}
