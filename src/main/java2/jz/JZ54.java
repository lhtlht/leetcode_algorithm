package jz;

import ht_tree.TreeNode;

public class JZ54 {
    int res,k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        kth(root);
        return res;
    }

    void kth(TreeNode node) {
        if(node != null) {
            kth(node.right);
            if(k == 0) {
                return;
            }
            k--;
            if(k == 0) {
                res = node.value;
            }
            kth(node.left);

        }
    }


}
