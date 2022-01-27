package jz;

import easy.ListNode;

public class JZ18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode pre = root;

        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
                break;
            }
            pre = head;
            head = head.next;
        }
        return root.next;
    }

//    public static void main(String[] args) {
//        JZ18 j = new JZ18();
//        ListNode r = new ListNode(1);
//        r.next = new ListNode(2);
//        r.next.next = new ListNode(3);
//        r.next.next.next = new ListNode(4);
//        r.next.next.next.next = new ListNode(5);
//
//        ListNode res = j.deleteNode(r);
//
//    }
}
