package jz;

import ht_tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class JZ32I {
    public int[] levelOrder(TreeNode root) {
        if(root == null) {
            return new int[] {};
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> res = new LinkedList<Integer>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.value);
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }

        }
        int[] r = new int[res.size()];
        for(int i=0; i<r.length; i++) {
            r[i] = res.get(i);
        }
        return r;


    }


}
