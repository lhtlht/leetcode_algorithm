package easy;

public class PRO141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        //快慢指针
        ListNode q = head.next;
        ListNode s = head;
        while (s != null && q != null) {
            if(q == s) {
                return true;
            }
            if(q.next == null) {
                return false;
            }
            q = q.next.next;
            s = s.next;
        }

        return false;

    }
}
