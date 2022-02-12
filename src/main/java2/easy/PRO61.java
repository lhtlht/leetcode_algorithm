package easy;

public class PRO61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0 || head.next == null) {
            return head;
        }
        int n = 1;
        ListNode count = head;
        while (count.next != null) {
            count = count.next;
            n++;
        }
        k = n - k%n;
        if (k == n) return head;
        count.next = head; // 变成循环列表
        while (k > 0) {
            count = count.next;
            k--;
        }
        ListNode res = count.next;
        count.next = null;
        return res;
    }

    public static void main(String[] args) {
        PRO61 p = new PRO61();
        ListNode n = new ListNode(1);
        ListNode res = p.rotateRight(n,1);
    }
}
