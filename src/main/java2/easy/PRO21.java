package easy;

public class PRO21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
         if(list1 == null && list2 == null) {
             return null;
         }
         if(list1 == null) {
             return list2;
         }
         if(list2 == null) {
             return list1;
         }

         ListNode res = new ListNode(0);
         ListNode cur = res;
         while (list1 != null && list2 != null) {
             if(list1.val < list2.val) {
                 cur.next = new ListNode(list1.val);
                 list1 = list1.next;
             } else {
                 cur.next = new ListNode(list2.val);
                 list2 = list2.next;
             }
             cur = cur.next;
         }
         while (list1 != null) {
             cur.next = new ListNode(list1.val);
             list1 = list1.next;
             cur = cur.next;
         }
        while (list2 != null) {
            cur.next = new ListNode(list2.val);
            list2 = list2.next;
            cur = cur.next;
        }

         return res.next;

    }


}
