package easy;

public class Solution234 {
    /*
    234. 回文链表
    请判断一个链表是否为回文链表。

    示例 1:

    输入: 1->2
    输出: false
    示例 2:

    输入: 1->2->2->1
    输出: true
    进阶：
    你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public boolean isPalindrome(ListNode head) {
        //快慢指针
        if (head == null || head.next == null) {
            return true;
        }

        //找到链表的中点
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //2、将slow之后链表进行断开且反转，最后翻转完成之后pre指向反转链表的头节点
        while (slow != null) {
            ListNode p = slow.next;
            slow.next = pre;
            pre = slow;
            slow = p;
        }
        //此时后半部分的链表进行反转之后变为pre
        //3、前后链表进行比较，注意若为奇数链表，后半部分回比前部分多1一个节点，然而我们只比较相同长度的节点值，巧妙地避开这点判断
        while (pre != null && head != null) {
            if (pre.val != head.val) {
                return false;
            }
            head = head.next;
            pre = pre.next;
        }

        return true;


    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        Solution234 s = new Solution234();
        s.isPalindrome(head);
    }
}
