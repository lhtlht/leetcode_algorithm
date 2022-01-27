package easy;

import ht_tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class pro101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            TreeNode l = queue.poll();
            TreeNode r = queue.poll();
            if (l == null && r == null) {
                continue;
            }
            if (l == null || r == null || l.value != r.value) {
                return false;
            }
            queue.add(l.left);
            queue.add(r.right);

            queue.add(l.right);
            queue.add(r.left);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(4);

        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);

        pro101 p = new pro101();
        System.out.println(p.isSymmetric(root));
    }
}
