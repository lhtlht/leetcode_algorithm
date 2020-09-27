package medium;

import java.util.LinkedList;
import java.util.Queue;

public class Solution513 {
    /*
    513. 找树左下角的值
    给定一个二叉树，在树的最后一行找到最左边的值。
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode curr = queue.poll();
                if (i == 0) {
                    res = curr.val;
                }
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
        }
        return res;
    }
}
