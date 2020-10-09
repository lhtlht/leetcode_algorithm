package medium;

import sun.reflect.generics.tree.Tree;

public class Solution654 {
    /*
    654. 最大二叉树
    给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：

    二叉树的根是数组中的最大元素。
    左子树是通过数组中最大值左边部分构造出的最大二叉树。
    右子树是通过数组中最大值右边部分构造出的最大二叉树。
    通过给定的数组构建最大二叉树，并且输出这个树的根节点。
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return maxTree(nums, 0, nums.length-1);

    }

    public TreeNode maxTree(int[] nums, int s, int e) {
        if (s > e) {
            return null;
        }
        int max = searchMax(nums, s, e);
        TreeNode root = new TreeNode(nums[max]);
        root.left = maxTree(nums, s, max-1);
        root.right = maxTree(nums, max+1, e);
        return root;
    }

    public int searchMax(int[] nums, int s, int e) {
        int max = s;
        for (int i=s; i<=e; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        return max;
    }
}
