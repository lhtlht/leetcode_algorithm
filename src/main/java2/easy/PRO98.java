package easy;

import ht_tree.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

public class PRO98 {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        double inorder = -Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.value <= inorder) {
                return false;
            }
            inorder = root.value;
            root = root.right;
        }

        return true;
    }
}
