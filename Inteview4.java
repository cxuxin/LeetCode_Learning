import utils.ListNode;

public class Inteview4 {
    public static ListNode problem(ListNode node, int value) {
        if(node == null){
            return new ListNode(value);
        }
        ListNode head = new ListNode();
        head.next = node;
        ListNode p = head;
        ListNode q = head.next;
        while(q != null){
            if(q.val > value){
                p.next = new ListNode(value);
                p.next.next = q;
                break;
            }else{
                p = p.next;
                q = q.next;
            }
        }
        if(q == null){
            p.next = new ListNode(value);
        }
        return head.next;

    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.buildList(new int[]{5,6,7});
        ListNode.showNodes(problem(l1,4));
    }
}
