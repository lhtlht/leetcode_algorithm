package easy;

import ht_tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class PRO144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        if (root == null) {
            return res;
        }
        preTree(root,res);
        return res;
    }

    public void preTree(TreeNode node, LinkedList<Integer> res) {
        if (node != null) {
            res.add(node.value);
            preTree(node.left,res);
            preTree(node.right,res);
        }
    }
}
