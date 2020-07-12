package easy;


public class Solution100 {
    /*
    100. 相同的树
    给定两个二叉树，编写一个函数来检验它们是否相同。

    如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     */

    /*
    时间复杂度 : O(N)O(N)，其中 N 是树的结点数，因为每个结点都访问一次。
    空间复杂度 : 最优情况（完全平衡二叉树）时为 O(\log(N))O(log(N))，最坏情况下（完全不平衡二叉树）时为 {O}(N)O(N)，用于维护递归栈。
     */
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        if (p.val != q.val) return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {

    }
}
