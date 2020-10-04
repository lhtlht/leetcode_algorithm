package jianzhi_offer;

public class Solution52 {
    /*
    剑指 Offer 52. 两个链表的第一个公共节点
    输入两个链表，找出它们的第一个公共节点。
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
        int lenA = 0;
        int lenB = 0;
        ListNode A = headA;
        ListNode B = headB;
        while (headA != null) {
            lenA++;
            headA = headA.next;
        }
        while (headB != null) {
            lenB++;
            headB = headB.next;
        }
        if (lenA > lenB) {
            int tmp = lenA;
            lenA = lenB;
            lenB = tmp;

            ListNode tm = A;
            A = B;
            B = tm;
        }

        while (lenA != lenB) {
            B = B.next;
            lenB--;
        }
        System.out.println(B.val);
        while (A != null && B != null && A != B) {
            A = A.next;
            B = B.next;
        }
        return A;
    }
}
