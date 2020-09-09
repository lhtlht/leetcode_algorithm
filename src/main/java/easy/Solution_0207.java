package easy;

public class Solution_0207 {
    /*
    面试题 02.07. 链表相交
    给定两个（单向）链表，判定它们是否相交并返回交点。
    请注意相交的定义基于节点的引用，而不是基于节点的值。换句话说，如果一个链表的第k个节点与另一个链表的第j个节点是同一节点（引用完全相同），则这两个链表相交。
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
        ListNode copyA = headA;
        ListNode copyB = headB;
        int lenA = 0;
        int lenB = 0;
        while (copyA != null) {
            copyA = copyA.next;
            lenA++;
        }
        while (copyB != null) {
            copyB = copyB.next;
            lenB++;
        }
        copyA = headA;
        copyB = headB;

        if (lenA < lenB) {
            int tmp = lenA;
            lenA = lenB;
            lenB = tmp;

            ListNode tep = copyA;
            copyA = copyB;
            copyB = tep;
        }

        // 长度差
        int gap = lenA - lenB;
        while (gap > 0) {
            copyA = copyA.next;
        }

        while (copyA != null) {
            if (copyA == copyB) {
                return copyA;
            }
            copyA = copyA.next;
            copyB = copyB.next;
        }
        return null;


    }
}
