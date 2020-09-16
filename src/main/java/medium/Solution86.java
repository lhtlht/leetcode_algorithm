package medium;

public class Solution86 {
    /*
    86. 分隔链表
    给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。

    你应当保留两个分区中每个节点的初始相对位置。

    示例:

    输入: head = 1->4->3->2->5->2, x = 3
    输出: 1->2->2->4->3->5
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode partition(ListNode head, int x) {
        ListNode pre = new ListNode(0);
        ListNode post = new ListNode(0);

        ListNode pre_p = pre;
        ListNode post_p = post;

        while (head != null) {
            if (head.val >= x) {
                post_p.next = head;
                post_p = post_p.next;
            } else {
                pre_p.next = head;
                pre_p = pre_p.next;
            }
            head = head.next;
        }
        post_p.next = null;
        pre_p.next = post.next;
        return pre.next;
    }

    public static void main(String[] args) {
        Solution86 s = new Solution86();
        ListNode root = new ListNode(1);
        root.next = new ListNode(4);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(2);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(2);
        s.partition(root, 3);

        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }
}
