package easy;

public class PRO206 {
    public ListNode reverseList(ListNode head) {
        return revList(head, null);
    }

    public ListNode revList(ListNode cur, ListNode pre) {
        if (cur == null) {
            return pre;
        }
        ListNode node = revList(cur.next, cur);
        cur.next = pre;

        return node;

    }


}
