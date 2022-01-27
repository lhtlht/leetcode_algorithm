package easy;

public class PRO234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        //下半段反转
        ListNode first = halfList(head);
        ListNode firstRev = reverseList(first);
        //判断回文
        ListNode p1 = head;
        ListNode p2 = firstRev;
        boolean res = true;
        while (res && p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        first.next = reverseList(firstRev);

        return res;

    }

    public ListNode halfList(ListNode node) {
        ListNode quick = node;
        ListNode slow = node;
        while (quick.next != null && quick.next.next != null) {
            quick = quick.next.next;
            slow = slow.next;
        }
        return slow;
    }
    private ListNode reverseList(ListNode head) {
        ListNode prev = head;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
