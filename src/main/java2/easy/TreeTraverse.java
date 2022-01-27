package easy;

import ht_tree.TreeNode;

import java.util.LinkedList;

public class TreeTraverse {
    /*前序遍历*/
    /*先访问根节点，再访问左右节点*/
    public void preTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        if (root.left != null) {
            preTraverse(root.left);
        }
        if (root.right != null) {
            preTraverse(root.right);
        }


    }

    /*中序遍历*/
    /*先访问左节点，再访问根节点，最后访问右节点*/
    public void midTraverse(TreeNode root) {
        if (root.left != null) {
            midTraverse(root.left);
        }
        System.out.println(root.value);
        if (root.right != null) {
            midTraverse(root.right);
        }
    }


    /*后序遍历*/
    /*先访问左右节点，再访问根节点*/
    public void postTraverse(TreeNode root) {
        if (root.left != null) {
            postTraverse(root.left);
        }
        if (root.right != null) {
            postTraverse(root.right);
        }
        System.out.println(root.value);
    }

    /*层次遍历*/
    public void levelTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            System.out.println(curNode.value);
            if (curNode.left != null) {
                queue.add(curNode.left);
            }
            if (curNode.right != null) {
                queue.add(curNode.right);
            }
        }

    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(4);

        TreeTraverse tt = new TreeTraverse();
        tt.levelTraverse(root);

    }
}
