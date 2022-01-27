package easy;

import ht_tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.max;

public class PRO111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        int p = 0;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty() && p == 0) {
            int it = queue.size();
            for (int i=0; i<it; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    p = 1;
                    break;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res++;
        }
        return res;

    };


}
