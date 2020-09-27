package medium;

import java.util.LinkedList;
import java.util.List;

public class Solution95 {
    /*
    95. 不同的二叉搜索树 II
    给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。



    示例：

    输入：3
    输出：
    [
      [1,null,3,2],
      [3,2,null,1],
      [3,1,null,null,2],
      [2,1,3],
      [1,null,2,null,3]
    ]
    解释：
    以上的输出对应以下 5 种不同结构的二叉搜索树：

       1         3     3      2      1
        \       /     /      / \      \
         3     2     1      1   3      2
        /     /       \                 \
       2     1         2                 3
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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTree(1,n);
    }

    public List<TreeNode> generateTree(int start, int end) {
        List<TreeNode> trees = new LinkedList<TreeNode>();
        if (start > end) {
            trees.add(null);
            return trees;
        }

        for (int i=start; i<=end; i++) {
            List<TreeNode> leftTrees = generateTree(start,i-1);
            List<TreeNode> rightTrees = generateTree(i+1,end);

            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currTree = new TreeNode(i); //根节点
                    currTree.left = left; //左边每个节点都可以做当前根节点的左节点
                    currTree.right = right;
                    trees.add(currTree);
                }
            }

        }
        return trees;
    }
}
