package easy;

import ht_tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class pro103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int q = 0;
        while(!queue.isEmpty()) {
            int it = queue.size();
            List<Integer> level = new LinkedList<Integer>();
            for (int i=0; i<it; i++) {
                TreeNode node = queue.poll();
                level.add(node.value);

                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            if (q == 0) {
                res.add(level);
                q = 1;
            } else {
                List<Integer> level2 = new LinkedList<Integer>();
                for (int i=level.size()-1; i>=0; i--) {
                    level2.add(level.get(i));
                }
                res.add(level2);
                q = 0;
            }

        }
        return res;
    }
}
