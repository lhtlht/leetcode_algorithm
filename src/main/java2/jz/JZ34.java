package jz;

import ht_tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class JZ34 {
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        res = new LinkedList<List<Integer>>();
        if (root == null) {
            return res;
        }
        LinkedList<Integer> tmp = new LinkedList<Integer>();
        pathSumHelp(root, target, tmp,0);
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

}
