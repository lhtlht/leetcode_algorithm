package medium;

public class Solution235 {
    /*
    235. 二叉搜索树的最近公共祖先
    给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

    百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

    例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //右大 左小
        if (Math.min(p.val, q.val) > root.val) {  //如果两者的最小值比root的值还大，则两者一定在root的右子树中
            return lowestCommonAncestor(root.right, p, q);
        } else if (Math.max(p.val, q.val) < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);


        Solution235 s = new Solution235();
        System.out.println(s.lowestCommonAncestor(root, root.left, root.right).val);
        System.out.println(s.lowestCommonAncestor(root, root.left, root.left.right).val);
    }
}
