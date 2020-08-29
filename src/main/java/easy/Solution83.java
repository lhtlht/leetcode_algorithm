package easy;

public class Solution83 {
    /*
    83. 删除排序链表中的重复元素
给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

示例 1:

输入: 1->1->2
输出: 1->2
示例 2:

输入: 1->1->2->3->3
输出: 1->2->3
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode root = head;
        while (head != null) {
            if (head.next != null && head.next.val == head.val) {
                head.next = head.next.next;
            }
            head = head.next;
        }
        return root;
    }

    public static void main(String[] args) {

    }
}
