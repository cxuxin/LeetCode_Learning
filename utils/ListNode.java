package utils;

import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int x){
        val = x;
        next = null;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    public static ListNode buildList(int[] nodes){
        ListNode head = new ListNode();
        ListNode p = head;
        for(int node:nodes){
            p.next = new ListNode(node);
            p = p.next;
        }
        return head.next;
    }
    public static void showNodes(ListNode listNode){
        ListNode p = listNode;
        while(p != null){
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }
}
