package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution102 {
    /*
    102. 二叉树的层序遍历
    给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;

        LinkedList<TreeNode> ts = new LinkedList<TreeNode>();
        ts.offer(root);

        while (!ts.isEmpty()) {
            int size = ts.size();
            List<Integer> tmp = new ArrayList<Integer>();

            for (int i=0; i<size; i++) {
                TreeNode s = ts.poll();
                tmp.add(s.val);
                if (s.left != null) {
                    ts.offer(s.left);
                }
                if (s.right != null) {
                    ts.offer(s.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }

    public static void main(String[] args) {

    }

}
