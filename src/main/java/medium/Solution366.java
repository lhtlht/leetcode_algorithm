package medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Solution366 {
    /*
    366. 寻找二叉树的叶子节点
    给你一棵二叉树，请按以下要求的顺序收集它的全部节点：

    依次从左到右，每次收集并删除所有的叶子节点
    重复如上过程直到整棵树为空


    示例:

    输入: [1,2,3,4,5]

              1
             / \
            2   3
           / \
          4   5

    输出: [[4,5,3],[2],[1]]
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        while (root != null) {
            List<Integer> tmp = new ArrayList<Integer>();
            root = dfs(root, tmp);
            ans.add(new ArrayList<Integer>(tmp));
        }
        return ans;
    }

    public TreeNode dfs(TreeNode node, List<Integer> tmp) {
        if (node == null) {
            return null;
        }
        if (node.left == null && node.right == null) {
            tmp.add(node.val);
            return null;
        }
        node.left = dfs(node.left, tmp);
        node.right = dfs(node.right, tmp);
        return node;
    }
}
