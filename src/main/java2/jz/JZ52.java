package jz;

import easy.ListNode;

public class JZ52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        int lenA = 0;
        int lenB = 0;
        while (a != null) {
            a = a.next;
            lenA ++;
        }
        while (b != null) {
            b = b.next;
            lenB ++;
        }

        while (lenA > lenB) {
            headA = headA.next;
            lenA --;
        }
        while (lenB > lenA) {
            headB = headB.next;
            lenB --;
        }
        while (headA != null) {
            if (headA == headB) {
                break;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return headA;


    }
}
