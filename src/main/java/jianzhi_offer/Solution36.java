package jianzhi_offer;

public class Solution36 {
    /*
    剑指 Offer 36. 二叉搜索树与双向链表
    输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。



    为了让您更好地理解问题，以下面的二叉搜索树为例：
     */
    static  class  Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    Node pre, head;
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        //中序遍历
        inOrder(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void inOrder(Node curr) {
        if (curr == null) {
            return;
        }
        inOrder(curr.left);
        if (pre != null) {
            pre.right = curr;
        } else {
            head = curr;
        }
        curr.left = pre;
        pre = curr;

        inOrder(curr.right);


    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        Solution36 s = new Solution36();
        s.inOrder(root);
    }
}
