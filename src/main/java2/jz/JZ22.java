package jz;

import easy.ListNode;

public class JZ22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode top = head;
        while (k > 0) {
            top = top.next;
            k --;
        }
        while (top != null) {
            head = head.next;
            top = top.next;
        }
        return top;

    }
}
