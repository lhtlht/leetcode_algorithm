package jz;

import ht_tree.TreeNode;

import java.util.LinkedList;

public class JZ26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A == null) {
            return false;
        }

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(A);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.value == B.value) {
                if (isSame(node, B)) {
                    return true;
                }
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
        }
        return false;

    }

    public boolean isSame(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if ((A == null && B != null) || A.value != B.value) {
            return false;
        }
        return isSame(A.left,B.left) && isSame(A.right,B.right);
    }
}
