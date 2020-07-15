package easy;

public class Solution206 {
    /*
    206. 反转链表
    反转一个单链表。

    示例:

    输入: 1->2->3->4->5->NULL
    输出: 5->4->3->2->1->NULL
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode last = reverseList(head.next); //取到最后一个节点
        head.next.next = head; //实现最后3个节点翻转
        head.next = null;
        return last;
    }
}
