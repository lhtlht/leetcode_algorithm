package medium;

public class Solution148 {
    /*
    148. 排序链表
    在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。

    示例 1:

    输入: 4->2->1->3
    输出: 1->2->3->4
    示例 2:

    输入: -1->5->3->4->0
    输出: -1->0->3->4->5
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        //从中点分割
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode post = slow.next;
        slow.next = null;
        //
        ListNode left = sortList(head);
        ListNode right = sortList(post);

        ListNode h = new ListNode(0);
        ListNode res = h;

        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left == null ? right : left;
        return res.next;
    }


    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        int len = getListLen(head);
        int intv = 1;

        ListNode res = new ListNode(0);
        res.next = head;

        ListNode pre;
        ListNode h;
        ListNode h1;
        ListNode h2;
        while (intv < len) {
            pre = res;  // 存储链表 + 0
            h = res.next; // 存储链表
            while (h != null) {
                //1 , 截取intv长度的链表
                int i = intv;
                h1 = h;
                while (i > 0 && h != null) {
                    h = h.next;
                    i--;
                }
                if (i > 0) break;
                //2
                i = intv;
                h2 = h;
                while (i > 0 && h != null) {
                    h = h.next;
                    i--;
                }

                int c1 = intv, c2 = intv - i;
                while (c1 > 0 && c2 > 0) {
                    if (h1.val < h2.val) {
                        pre.next = h1;
                        h1 = h1.next;
                        c1--;
                    } else {
                        pre.next = h2;
                        h2 = h2.next;
                        c2--;
                    }
                    pre = pre.next;
                }
                pre.next = c1 == 0 ? h2 : h1;
                while (c1 > 0 || c2 > 0) {
                    pre = pre.next;
                    c1--;
                    c2--;
                }
                pre.next = h;


            }
            intv *= 2;
        }
        return res.next;

    }

    public int getListLen(ListNode head) {
        int len = 0;
        while (head != null) {
            len ++;
            head = head.next;
        }
        return len;
    }
    public static void main(String[] args) {
        ListNode p = new ListNode(4);
        p.next = new ListNode(2);
        p.next = new ListNode(1);
        p.next = new ListNode(3);


        Solution148 s = new Solution148();
        s.sortList2(p);
    }
}
