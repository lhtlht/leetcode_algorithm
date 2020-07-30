package medium;

import java.util.Arrays;

public class Solution105 {
    /*
    105. 从前序与中序遍历序列构造二叉树
    根据一棵树的前序遍历与中序遍历构造二叉树。

    注意:
    你可以假设树中没有重复的元素。

    例如，给出

    前序遍历 preorder = [3,9,20,15,7]
    中序遍历 inorder = [9,3,15,20,7]
    返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7

     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int n = preorder.length;
        TreeNode root = new TreeNode(preorder[0]);
        for (int i=0; i<n; i++) {
            if (inorder[i] == preorder[0]) {
                int[] preLeft = Arrays.copyOfRange(preorder,1,i+1);
                int[] preRight = Arrays.copyOfRange(preorder,i+1,n);

                int[] inLeft = Arrays.copyOfRange(inorder,0,i);
                int[] inRight = Arrays.copyOfRange(inorder,i+1,n);

                root.left = buildTree(preLeft, inLeft);
                root.right = buildTree(preRight, inRight);
                break;
            }
        }

        return root;

    }


    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int n = preorder.length;
        return buildTreeFor(preorder, inorder, 0,n,0,n);
    }


    public TreeNode buildTreeFor(int[] preorder, int[] inorder, int iPre, int jPre, int iIn, int jIn) {
        if (iPre == jPre) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[iPre]);
        for (int i=iIn; i<jIn; i++) {
            if (inorder[i] == preorder[iPre]) {
                root.left = buildTreeFor(preorder, inorder, iPre+1, iPre + i-iIn + 1, iIn, i);
                root.right = buildTreeFor(preorder, inorder, iPre + i-iIn + 1, jPre, i+1, jIn);
                break;
            }
        }
        return root;
    }
}
