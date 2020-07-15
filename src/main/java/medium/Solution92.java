package medium;

public class Solution92 {
    /*
    92. 反转链表 II
    反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

    说明:
    1 ≤ m ≤ n ≤ 链表长度。

    示例:

    输入: 1->2->3->4->5->NULL, m = 2, n = 4
    输出: 1->4->3->2->5->NULL
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m-1, n-1);
        return head;
    }

    //反转前n个节点
    ListNode succesor = null;
    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            succesor =  head.next; //保存第n+1个节点
            return head; //返回需要反转的最后一个节点
        }
        ListNode last = reverseN(head.next, n-1);
        head.next.next = head;
        head.next = succesor;
        return last;
    }
}
