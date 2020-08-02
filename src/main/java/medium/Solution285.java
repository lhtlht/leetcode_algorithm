package medium;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Stack;

public class Solution285 {
    /*
    285. 二叉搜索树中的顺序后继
给你一个二叉搜索树和其中的某一个结点，请你找出该结点在树中顺序后继的节点。

结点 p 的后继是值比 p.val 大的结点中键值最小的结点。
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    boolean flag = false;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        //第一种情况：如果当前节点有右孩子，顺序后继在当前节点之下
        //如果当前节点有右孩子，找到右孩子，再持续往左走直到节点左孩子为空，直接返回该节点
        if (p.right != null) {
            p = p.right;
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }

        //第二种情况 如果当前没有右节点的话，顺序后继在当前节点之上，如下图中蓝色节点所示。
        /*
        如果没有的话，就需要用到非递归的中序遍历。维持一个栈，当栈中有节点时：

        往左走直到节点的左孩子为空，并将每个访问过的节点压入栈中。
        弹出栈中节点，判断当前的前继节点是否为 p，如果是则直接返回当前节点。如果不是，将当前节点赋值给前继节点。
        往右走一步。
        如果走到这一步，说明不存在顺序后继，返回空。
         */

        Stack<TreeNode> stack = new Stack<TreeNode>();
        int inorder = Integer.MIN_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (inorder == p.val) {
                return root;
            }
            inorder = root.val;
            root = root.right;
        }
        return null;

    }
}
