package jianzhi_offer;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution54 {
    /*
    剑指 Offer 54. 二叉搜索树的第k大节点
    给定一棵二叉搜索树，请找出其中第k大的节点。
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int res;
    int k;
    public int kthLargest(TreeNode root, int k) {
        //二叉搜索树性质：中序遍历为递增序列
        this.k = k;
        midOrder(root);
        return res;
    }

    public void midOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        midOrder(node.right);
        System.out.println(node.val + " " + k);
        if (k == 1) {
            res = node.val;
            k--;
            return;
        }
        k--;
        midOrder(node.left);


    }


    public static void main(String[] args) {
        Solution54 s = new Solution54();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        System.out.println(s.kthLargest(root, 1));
    }
}
