package LinkList;

import utils.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        ListNode start = new ListNode();
        ListNode p = start;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for(ListNode node : lists){
            if(node != null){
                pq.add(node);
            }
        }
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            p.next = node;
            if(node.next != null){
                pq.add(node.next);
            }
            p = p.next;
        }
        return start.next;
    }
}
