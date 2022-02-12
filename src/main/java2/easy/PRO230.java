package easy;

import ht_tree.TreeNode;

public class PRO230 {
    int res;
    public int kthSmallest(TreeNode root, int k) {
        res = 0;
        dfs(root,k);
        return res;
    }

    public int dfs(TreeNode node, int k) {
        if (node == null){
            return k;
        }

        int k1 = dfs(node.left, k);
        k1--;
        if (k1 == 0) {
            res = node.value;
        }
        int k2 = dfs(node.right, k1);
        return k2;
    }

    public static void main(String[] args) {
        PRO230 p = new PRO230();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        System.out.println(p.kthSmallest(root,3));
    }
}
