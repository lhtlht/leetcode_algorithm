package jianzhi_offer;

public class Solution07 {
    /*
    剑指 Offer 07. 重建二叉树
    输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。



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
        return buildTree(preorder, inorder, 0, n, 0, n);

    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int ip, int jp, int ii, int ji) {
        if (ip == jp) return null;
        TreeNode root = new TreeNode(preorder[ip]);
        for (int i=ii; i<ji; i++) {
            if (inorder[i] == preorder[ip]) {
                root.left = buildTree(preorder, inorder, ip+1, ip+1 + i-ii, ii, i);
                root.right = buildTree(preorder, inorder, ip+1 + i-ii, jp, i+1, ji);
                break;
            }
        }

        return root;
    }

    public static void main(String[] args) {

    }

}
