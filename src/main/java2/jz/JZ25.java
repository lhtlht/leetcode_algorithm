package jz;

import easy.ListNode;

public class JZ25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        return merge(l1,l2);

    }

    public ListNode merge(ListNode x, ListNode y) {
        if (x == null) {
            return y;
        }
        if (y == null) {
            return x;
        }
        if(x.val <= y.val) {
            x.next = merge(x.next, y);
            return x;
        } else {
            y.next = merge(x, y.next);
            return y;
        }


    }

}
