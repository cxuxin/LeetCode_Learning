package LinkList;

import utils.ListNode;

import static utils.ListNode.buildList;
import static utils.ListNode.showNodes;

/*
 * 203. 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *
 * 示例 1：
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 *
 * 示例 2：
 * 输入：head = [], val = 1
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *
 * 提示：
 * 列表中的节点在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= k <= 50
 *
 * 链接：https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class Problem_203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode start = new ListNode();
        start.next = head;
        ListNode p = start;
        while(p.next != null){
            if (p.next.val == val){
                p.next = p.next.next;
            }else{
                p = p.next;
            }
        }
        return start.next;
    }

    public static void main(String[] args) {
        ListNode listNode = buildList(new int[]{1,2,6,3,4,5,6});
        showNodes(listNode);
        showNodes(new Problem_203().removeElements(listNode,6));
    }
}
