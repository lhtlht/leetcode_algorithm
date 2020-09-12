package medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution199 {
    /*
    199. 二叉树的右视图
    给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

    示例:

    输入: [1,2,3,null,5,null,4]
    输出: [1, 3, 4]
    解释:

       1            <---
     /   \
    2     3         <---
     \     \
      5     4       <---
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Integer> rightSideView(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
                if (i == size-1) {
                    res.add(curr.val);
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {

    }
}
