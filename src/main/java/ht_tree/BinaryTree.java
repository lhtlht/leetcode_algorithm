package ht_tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTree {
    public TreeNode root = null;
    public BinaryTree(int[] array, int index) {
        this.root = createBinaryTree(array,index);
    }

    private TreeNode createBinaryTree(int[] array, int index) {
        TreeNode treeNode = null;
        if (index < array.length) {
            treeNode = new TreeNode(array[index]);
            treeNode.left = createBinaryTree(array, 2*index+1);
            treeNode.right = createBinaryTree(array, 2*index+2);
        }
        return treeNode;
    }

    //前序
    public void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    //中序
    public void minOrder(TreeNode root) {
        if (root != null) {
            minOrder(root.left);
            System.out.print(root.value + " ");
            minOrder(root.right);
        }
    }

    //后序
    public void postOrder(TreeNode root) {
        if (root != null) {
            minOrder(root.left);
            minOrder(root.right);
            System.out.print(root.value + " ");
        }
    }

    //层次 BFS
    public void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> ts = new LinkedList<TreeNode>();
        ts.offer(root);
        while (!ts.isEmpty()) {
            TreeNode node = ts.poll();
            System.out.print(node.value + " ");
            if (node.left != null) {
                ts.offer(node.left);
            }
            if (node.right != null) {
                ts.offer(node.right);
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        BinaryTree t = new BinaryTree(arr,0);
        t.preOrder(t.root);
        System.out.println();

        t.minOrder(t.root);
        System.out.println();

        t.postOrder(t.root);
        System.out.println();

        t.levelOrder(t.root);
        System.out.println();

    }

}
