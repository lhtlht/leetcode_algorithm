package easy;

import java.util.ArrayList;
import java.util.List;

public class Solution589 {
    /*
    589. N叉树的前序遍历
    给定一个 N 叉树，返回其节点值的前序遍历。

    例如，给定一个 3叉树 :







    返回其前序遍历: [1,3,5,6,2,4]。
     */
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };


    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<Integer>();
        if (root == null) return ans;
        preorderHelp(root, ans);
        return ans;
    }

    public void preorderHelp(Node root, List<Integer> ans) {
        if (root.children == null) return;
        ans.add(root.val);
        for (Node node : root.children) {
            preorderHelp(node, ans);
        }
    }



}
