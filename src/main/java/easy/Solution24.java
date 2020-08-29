package easy;

public class Solution24 {
    /*
    剑指 Offer 24. 反转链表
    定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。



    示例:

    输入: 1->2->3->4->5->NULL
    输出: 5->4->3->2->1->NULL
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode root = head;
        while (head.next != null) {
            ListNode tmp = head.next;
            head.next = head.next.next;
            tmp.next = root;
            root = tmp;
        }
        return root;
    }


    public static void main(String[] args) {
        Solution24 s = new Solution24();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println(s.reverseList(head).val);
    }
}
