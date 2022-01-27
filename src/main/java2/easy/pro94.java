package easy;

import ht_tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class pro94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        travHelp(root,res);
        return res;
    }
    public void travHelp(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            travHelp(node.left, res);
        }

        res.add(node.value);
        if (node.right != null) {
            travHelp(node.right, res);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        pro94 p = new pro94();
        System.out.println(p.inorderTraversal(root));
    }
}
