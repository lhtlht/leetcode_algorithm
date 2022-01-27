package easy;

import ht_tree.TreeNode;

public class PRO543 {
    int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        highTree(root);
        return diameter;
    }

    public int highTree(TreeNode node) {
        if (node == null) {
            return -1;
        }
        int leftHigh =  highTree(node.left) + 1;
        int rightHigh = highTree(node.right) + 1;

        diameter = Math.max(diameter, leftHigh+rightHigh);
        return Math.max(leftHigh, rightHigh);
    }


}
