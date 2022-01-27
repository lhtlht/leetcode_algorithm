package jz;
class Node2 {
    public int val;
    public Node2 left;
    public Node2 right;

    public Node2() {}

    public Node2(int _val) {
        val = _val;
    }

    public Node2(int _val,Node2 _left,Node2 _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
public class JZ36 {
    Node2 head, pre;
    public Node2 treeToDoublyList(Node2 root) {
        if(root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void dfs(Node2 node) {
        if(node == null) return;
        dfs(node.left);
        if(pre != null) {
            pre.right = node;
        } else {
            head = node;
        }
        node.left = pre;
        pre = node;
        dfs(node.right);
    }
}
