package easy;

import ht_tree.BinaryTree;
import ht_tree.TreeNode;

public class Solution572 {
    /**
     * 572. 另一个树的子树
     * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (t==null) return true;
        if (s==null) return false;

        return isSubtree(s.left, t) || isSubtree(s.right, t) || isSameTree(s,t);
    }

    public static boolean isSameTree(TreeNode s, TreeNode t){
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.value != t.value) return false;
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }

    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        BinaryTree t = new BinaryTree(arr,0);
        t.levelOrder(t.root);

        int[] arr1 = {4,1,2};
        BinaryTree t1 = new BinaryTree(arr,0);
        t.levelOrder(t1.root);

        System.out.println(Solution572.isSubtree(t.root,t1.root));

    }
}
