package easy;

import ht_tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class PRO113 {
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new LinkedList<List<Integer>>();
        if (root == null) {
            return res;
        }
        LinkedList<Integer> tmp = new LinkedList<Integer>();
        pathSumHelp(root, targetSum, tmp,0);
        return res;

    }
    public void pathSumHelp(TreeNode node, int tar, LinkedList<Integer> tmp, int sum) {
        if (node != null) {
            int nsum = sum + node.value;
            tmp.add(node.value);
            if (node.left == null && node.right == null && nsum == tar) {
                res.add(new LinkedList<Integer>(tmp));
            }

            pathSumHelp(node.left, tar, tmp, nsum);
            pathSumHelp(node.right, tar, tmp, nsum);

            tmp.remove(tmp.size()-1);
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

        PRO113 p = new PRO113();
        List<List<Integer>> res = p.pathSum(root,22);
        System.out.println(res);
    }
}
