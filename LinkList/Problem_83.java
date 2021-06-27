package LinkList;

import utils.ListNode;

import java.util.List;

/**
 * 83. 删除排序链表中的重复元素
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * 返回同样按升序排列的结果链表。
 *
 * 示例 1：
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 *
 * 示例 2：
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 *
 * 提示：
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 *
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
public class Problem_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode p = head;
        ListNode q = head;
        int number = head.val;
        while(q.next != null){
            if(number != q.next.val){
                number = q.next.val;
                p.next = q.next;
                p = p.next;
            }
            q = q.next;
        }
        p.next = null;
        return head;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode cur = head;
        while(cur.next != null){
            if(cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.buildList(new int[]{1,1,2,2,3,3,4,5,6,6,7,7,8,8,8,8,8,9});
        ListNode.showNodes(head);
        ListNode newHead = new Problem_83().deleteDuplicates1(head);
        ListNode.showNodes(newHead);
    }
}
