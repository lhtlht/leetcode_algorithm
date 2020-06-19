package medium;

import ht_tree.BinaryTree;
import ht_tree.TreeNode;

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * /
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution1028 {
    /**
     * 我们从二叉树的根节点 root 开始进行深度优先搜索。

     在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。


     给出遍历输出 S，还原树并返回其根节点 root。
     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param S
     * @return
     */
    public static TreeNode recoverFromPreorder(String S) {
        //时间复杂度O（s）  s为S的长度
        //空间复杂度O（h） 栈的存储，最大为树的深度
        Stack<TreeNode> path = new Stack<TreeNode>();
        int pos = 0; //记录字符串中字符的位置
        while (pos < S.length()) {
            int level = 0; //记录当前值的层
            while (S.charAt(pos)=='-') {
                level++;
                pos++;
            }
            int value = 0; //寻找当前的值
            while ( pos<S.length() && Character.isDigit(S.charAt(pos))) {
                value = value * 10 + (S.charAt(pos)-'0');
                pos++;
            }

            TreeNode node = new TreeNode(value);
            if (level == path.size()) { //使用栈模拟当前层点
                if (!path.isEmpty()) {
                    path.peek().left = node;
                }

            } else {
                while (level != path.size()) {
                    path.pop();
                }
                path.peek().right = node;
            }
            path.push(node);


        }
        while (path.size()>1){
            path.pop();
        }
        return path.peek();
    }

    public static void main(String[] args) {
        String S = "1-2--3---4-5--6---7";
        TreeNode root = Solution1028.recoverFromPreorder(S);

        int[] arr = {1,2,3,4,5,6,7,8,9};
        BinaryTree t = new BinaryTree(arr,0);
        t.levelOrder(root);
        System.out.println();



    }
}
