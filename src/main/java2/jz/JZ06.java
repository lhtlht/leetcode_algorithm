package jz;

import easy.ListNode;

import java.util.LinkedList;
import java.util.List;

public class JZ06 {
    public int[] reversePrint(ListNode head) {
        List<Integer> res = new LinkedList<Integer>();
        revList(head,res);
        int[] arr = new int[res.size()];
        for (int i=0; i<res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    public void revList(ListNode node, List<Integer> res) {
        if(node == null) {
            return;
        }
        revList(node.next,res);
        res.add(node.val);
    }


    public int[] reversePrint2(ListNode head) {
        List<Integer> res = new LinkedList<Integer>();
        revList(head,res);

        int[] arr = new int[res.size()];
        for (int i=0; i<res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }




}
