package easy;

import ht_tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class PRO257 {
    List<String> res;
    public List<String> binaryTreePaths(TreeNode root) {
        res = new LinkedList<String>();
        if (root == null) {
            return res;
        }
        String tmp = String.valueOf(root.value);
        if (root.left == null && root.right == null) {
            res.add(new String(tmp));
        }
        if (root.left != null) {
            joinPath(root.left, tmp);
            //tmp = tmp.substring(0,tmp.length()-2-String.valueOf(root.left.value).length());
        }
        joinPath(root.right, tmp);
        return res;

    }

    public void joinPath(TreeNode node, String tmp) {
        if(node == null) {
            return;
        }
        tmp = tmp + "->" + node.value;
        if (node.left == null && node.right == null) {
            res.add(new String(tmp));
        }
        if (node.left != null) {
            joinPath(node.left, tmp);
            //tmp = tmp.substring(0,tmp.length()-2-String.valueOf(node.left.value).length());
        }
        joinPath(node.right,tmp);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(6);

        PRO257 p = new PRO257();
        System.out.println(p.binaryTreePaths(root));
    }


}
