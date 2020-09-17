package medium;

public class Solution143 {
    /*
    143. 重排链表
    给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
    将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…

    你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

    示例 1:

    给定链表 1->2->3->4, 重新排列为 1->4->2->3.
    示例 2:

    给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode post = slow.next;
        slow.next = null;

        post = reverseList(post);
        ListNode pre = head;
        while (post != null) {
            ListNode tmp1 = pre.next;
            ListNode tmp2 = post.next;
            pre.next = post;
            post.next = tmp1;
            post = tmp2;
            pre = pre.next.next;
        }

    }

    public ListNode reverseList(ListNode root) {
        //翻转链表
        if (root == null) return null;
        if (root.next == null) return root;
        ListNode last = reverseList(root.next);
        root.next.next = root;
        root.next = null;
        return last;
    }

    public static void main(String[] args) {
        Solution143 s = new Solution143();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        s.reorderList(head);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
