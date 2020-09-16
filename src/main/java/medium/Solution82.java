package medium;

public class Solution82 {
    /*
    82. 删除排序链表中的重复元素 II
    给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

    示例 1:

    输入: 1->2->3->3->4->4->5
    输出: 1->2->5
    示例 2:

    输入: 1->1->1->2->3
    输出: 2->3
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode root = dummy;
        boolean dump = false;
        while (head != null && head.next != null) {
            while (head != null && head.next != null && head.val == head.next.val) {
                    head = head.next;
                    dump = true;
            }
            if (dump) {
                root.next = head.next;
            } else {
                root = root.next;
            }
            dump = false;
            head = head.next;
        }
        return dummy.next;
    }
}
