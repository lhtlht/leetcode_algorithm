package medium;

public class Solution61 {
    /*
    61. 旋转链表
    给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

    示例 1:

    输入: 1->2->3->4->5->NULL, k = 2
    输出: 4->5->1->2->3->NULL
    解释:
    向右旋转 1 步: 5->1->2->3->4->NULL
    向右旋转 2 步: 4->5->1->2->3->NULL
    示例 2:

    输入: 0->1->2->NULL, k = 4
    输出: 2->0->1->NULL
    解释:
    向右旋转 1 步: 2->0->1->NULL
    向右旋转 2 步: 1->2->0->NULL
    向右旋转 3 步: 0->1->2->NULL
    向右旋转 4 步: 2->0->1->NULL
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode old = head;
        int n = 1;
        while (old.next != null) {
            old = old.next;
            n++;
        }
        old.next = head;

        ListNode newHead = head;
        for (int i = 0; i < n - k%n - 1; i++)
            newHead = newHead.next;
        ListNode new_head = newHead.next;

        newHead.next = null;
        return new_head;
    }

    public static void main(String[] args) {
        ListNode p0 = new ListNode(1);
        p0.next = new ListNode(2);
//        p0.next.next = new ListNode(3);
//        p0.next.next.next = new ListNode(4);
//        p0.next.next.next.next = new ListNode(5);

        Solution61 s = new Solution61();
        ListNode res = s.rotateRight(p0,1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }


    }
}
