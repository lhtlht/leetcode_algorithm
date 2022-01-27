package jz;

import easy.ListNode;

public class JZ24 {
    ListNode res;
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode dd = revListHelp(head);
        return res;

    }

    public ListNode revListHelp(ListNode node) {
        if (node.next == null) {
            res = node;
            return node;
        }
        ListNode curr = revListHelp(node.next);
        node.next = null;
        curr.next = node;
        return node;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        JZ24 j = new JZ24();
        ListNode res = j.reverseList(head);
        System.out.println("----------------------");
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }



}
