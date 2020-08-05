package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution103 {
    /*
    103. 二叉树的锯齿形层次遍历
    给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

    例如：
    给定二叉树 [3,9,20,null,null,15,7],

        3
       / \
      9  20
        /  \
       15   7
    返回锯齿形层次遍历如下：

    [
      [3],
      [20,9],
      [15,7]
    ]
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> currNodeList = new LinkedList<TreeNode>();
        currNodeList.add(root);
        boolean odd = true;
        while (!currNodeList.isEmpty()) {
            int currSize = currNodeList.size();
            LinkedList<Integer> tmp = new LinkedList<Integer>();
            for (int i=0; i<currSize; i++) {
                TreeNode curr = currNodeList.poll();
                if (curr.left != null) {
                    currNodeList.add(curr.left);
                }
                if (curr.right != null) {
                    currNodeList.add(curr.right);
                }
                if (odd) {
                    tmp.add(curr.val); //加在尾部
                } else {
                    tmp.push(curr.val); //加在头部
                }
            }
            if (odd) {
                odd = false;
            } else {
                odd = true;
            }

            res.add(tmp);
        }

        return res;

    }

    public static void main(String[] args) {
        Solution103 s = new Solution103();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(s.zigzagLevelOrder(root));
    }

}
