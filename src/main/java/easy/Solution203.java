package easy;

public class Solution203 {
    /*
    203. 移除链表元素
    删除链表中等于给定值 val 的所有节点。

    示例:

    输入: 1->2->6->3->4->5->6, val = 6
    输出: 1->2->3->4->5
     */

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val == val) {
                pre.next = curr.next;
            } else {
                pre = curr;
            }
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution203 s = new Solution203();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);

        ListNode res = s.removeElements(head,1 );
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
