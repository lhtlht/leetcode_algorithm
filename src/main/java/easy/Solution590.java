package easy;

import java.util.ArrayList;
import java.util.List;

public class Solution590 {
    /*
    590. N叉树的后序遍历
给定一个 N 叉树，返回其节点值的后序遍历。

例如，给定一个 3叉树 :
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
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<Integer>();
        if (root == null) return ans;
        postorderHelp(root, ans);
        return ans;
    }

    public void postorderHelp(Node root, List<Integer> ans) {
        if (root.children == null) {
            return;
        }

        for (Node node : root.children) {
            postorderHelp(node, ans);
        }
        ans.add(root.val);
    }




}
