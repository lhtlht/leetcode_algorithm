package easy;

import java.util.*;

public class Solution429 {
    /*
    429. N叉树的层序遍历
    给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。

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

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null) return ans;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<Integer>();
            for (int i=0; i<size; i++) {
                Node curr = queue.poll();
                level.add(curr.val);
                if (curr.children != null) {
                    for (Node node : curr.children) {
                        queue.add(node);
                    }
                }
            }
            ans.add(new ArrayList<Integer>(level));
        }
        return ans;
    }
}
