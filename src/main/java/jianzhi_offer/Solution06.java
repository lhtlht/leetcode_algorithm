package jianzhi_offer;

public class Solution06 {
    /*
    剑指 Offer 06. 从尾到头打印链表
    输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。



    示例 1：

    输入：head = [1,3,2]
    输出：[2,3,1]


    限制：

    0 <= 链表长度 <= 10000
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    ListNode res;
    int size;
    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[] {};
        revse(head);
        int[] ans = new int[size];
        int index = 0;
        while (res != null) {
            ans[index++] = res.val;
            res = res.next;
        }
        return ans;
    }

    public ListNode revse(ListNode node) {
        size++;
        if (node.next == null) {
            res = node;
            return node;
        }
        ListNode next = revse(node.next);
        node.next = null;
        next.next = node;
        return node;
    }


    public static void main(String[] args) {
        Solution06 s = new Solution06();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int[] res = s.reversePrint(head);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
