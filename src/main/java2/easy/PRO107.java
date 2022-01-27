package easy;

import ht_tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PRO107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int it = queue.size();
            List<Integer> level = new LinkedList<Integer>();
            for (int i=0; i<it; i++) {
                TreeNode node = queue.poll();
                level.add(node.value);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.addFirst(level);
        }
        return res;
    }
}
