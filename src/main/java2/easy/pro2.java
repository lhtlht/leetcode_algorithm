package easy;


public class pro2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int val = l1.val + l2.val;
        ListNode res = new ListNode(val%10);
        res.next = addTwoNumbers(l1.next, l2.next);
        if (val >= 10) {
            res.next = addTwoNumbers(res.next, new ListNode(val/10));
        }
        return res;

    }


    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        return numsTail(l1,l2,0);
    }

    public static ListNode numsTail(ListNode l1, ListNode l2, int add) {
        if(l1 == null && l2 == null && add == 0) {
            return null;
        }
        if (l1 != null) {
            add += l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            add += l2.val;
            l2 = l2.next;
        }
        ListNode res = new ListNode(add%10);
        res.next = numsTail(l1,l2,add/10);
        return res;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode res = addTwoNumbers(l1,l2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
