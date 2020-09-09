package medium;

public class Solution24 {
    /*
    24. 两两交换链表中的节点
    给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

    你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。



    示例:

    给定 1->2->3->4, 你应该返回 2->1->4->3.
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode swapPairs(ListNode head) {
        ListNode res = new ListNode(0);
        res.next = head;

        ListNode preNode = res;
        while (head != null && head.next != null) {
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            preNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            preNode = firstNode;
            head = firstNode.next;

        }
        return res.next;
    }

    public static void main(String[] args) {
        Solution24 s = new Solution24();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode root = s.swapPairs(head);
        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }
}
