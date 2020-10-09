package medium;

import java.util.Stack;

public class Solution445 {
    /*
    445. 两数相加 II
    给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
    你可以假设除了数字 0 之外，这两个数字都不会以零开头。
    进阶：
    如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
    示例：
    输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
    输出：7 -> 8 -> 0 -> 7
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //栈
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode ans = null;
        while (!s1.isEmpty() || !s2.isEmpty() || carry!=0) {
            int x1 = s1.isEmpty()? 0:s1.pop();
            int x2 = s2.isEmpty()? 0:s2.pop();

            int y = x1+x2+carry;
            ListNode curr = new ListNode(y%10);
            carry = y/10;

            curr.next = ans;
            ans = curr;
        }
        return ans;
    }


}
