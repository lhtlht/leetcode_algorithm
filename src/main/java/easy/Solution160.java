package easy;

public class Solution160 {
    /*
    160. 相交链表
    编写一个程序，找到两个单链表相交的起始节点。
     */

    /*
    注意：

    如果两个链表没有交点，返回 null.
    在返回结果后，两个链表仍须保持原有的结构。
    可假定整个链表结构中没有循环。
    程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ha = headA;
        ListNode hb = headB;

        while (ha != hb) {
            ha = ha != null? ha.next:headB;
            hb = hb != null? hb.next:headA;
        }
        return ha;



    }


}
