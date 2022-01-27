package easy;

public class PRO19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = new ListNode(0);
        tmp.next = head;
        ListNode node = tmp;
        ListNode pre = tmp;

        while (n>0){
            pre = pre.next;
            n--;
        }
        while (pre.next != null) {
            pre = pre.next;
            node = node.next;
        }
        node.next = node.next.next;

        return tmp.next;

    }
}
