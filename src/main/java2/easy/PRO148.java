package easy;

import java.util.List;

public class PRO148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode midNode = midNode(head);
        ListNode rigNode = midNode.next;
        midNode.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(rigNode);


        return mergeTwoList(left, right);
    }

    public ListNode midNode(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode slow = node;
        ListNode fast = node.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode tmp = new ListNode(-1);
        ListNode curr = tmp;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 != null ? l1 : l2;
        return tmp.next;
    }
}
