package easy;

public class Solution237 {
    /**
     * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
     现有一个链表 -- head = [4,5,1,9]，它可以表示为:

    时间和空间复杂度都是O（1）

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/delete-node-in-a-linked-list
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param node
     */
    public static void deleteNode(ListNode node) {
        node.val = node.next.val; //将想要删除的节点的值替换为它后面节点中的值，然后删除它之后的节点。
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(9);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;

        Solution237.deleteNode(n1);

    }
}
