package utils;

public class ListNode {
    int val;
    public ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
    public ListNode buildList(int[] nodes){
        ListNode head = new ListNode(0);
        ListNode p = head;
        for(int node:nodes){
            p.next = new ListNode(node);
            p = p.next;
        }
        return head.next;
    }
}
