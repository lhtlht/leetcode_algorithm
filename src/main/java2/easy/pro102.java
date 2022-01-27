package easy;

import ht_tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class pro102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int it = queue.size();
            List<Integer> level = new LinkedList<Integer>();
            for (int i=0; i<it; i++){
                TreeNode node = queue.poll();
                level.add(node.value);


                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);


        }
        return res;

    }
}
