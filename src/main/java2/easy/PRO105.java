package easy;

import ht_tree.TreeNode;

import java.util.HashMap;

public class PRO105 {
    private HashMap<Integer, Integer> inMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inMap = new HashMap<Integer, Integer>();
        for (int i=0; i<inorder.length; i++) {
            inMap.put(inorder[i],i);
        }
        return buildTreeHelp(preorder, inorder, 0,preorder.length-1, 0, inorder.length-1);
    }
    public TreeNode buildTreeHelp(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        if (pl > pr) {
            return null;
        }
        int prRoot = pl; //前序遍历的根节点下标
        int inRoot = inMap.get(preorder[prRoot]); //中序遍历的根节点下标

        int leftLen = inRoot - il;
        int rightLen = ir = inRoot;

        TreeNode root = new TreeNode(preorder[prRoot]);

        root.left = buildTreeHelp(preorder, inorder, pl+1,pl+leftLen, il, inRoot-1);
        root.right = buildTreeHelp(preorder, inorder, pl+leftLen+1,pr, inRoot+1, ir);
        return root;
    }




    public static void main(String[] args) {
        PRO105 p = new PRO105();
        int[] p1 = new int[] {3,9,20,15,7};
        int[] i1 = new int[] {9,3,15,20,7};
        TreeNode res = p.buildTree(p1, i1);

        TreeTraverse tt = new TreeTraverse();
        tt.preTraverse(res);

    }
}
