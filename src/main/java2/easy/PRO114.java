package easy;

import ht_tree.TreeNode;

public class PRO114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            TreeNode r = rnode(root.left);
            if (r != null) {
                r.right = root.right;
                root.right = root.left;
                root.left = null;
            }
        }
        flatten(root.right);

    }

    public TreeNode rnode(TreeNode root) {
            if(root.right==null){
                return root;
            }
            return rnode(root.right);
    }
}
