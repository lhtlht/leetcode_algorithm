package jz;

import ht_tree.TreeNode;

import java.util.HashMap;

public class JZ07 {
    private HashMap<Integer, Integer> inMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inMap = new HashMap<Integer, Integer>();
        for (int i=0; i<inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTreeHelp(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    public TreeNode buildTreeHelp(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        if (pl > pr) return null;
        int proot = pl;
        int iroot = inMap.get(preorder[proot]);

        int leftLen = iroot - il;
        int rightLen = ir - iroot;

        TreeNode root = new TreeNode(preorder[proot]);
        root.left = buildTreeHelp(preorder, inorder, pl+1, pl+leftLen, il, iroot-1);
        root.right = buildTreeHelp(preorder, inorder, pl+leftLen+1, pr,iroot+1, ir);

        return root;

    }
}
