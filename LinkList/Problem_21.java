package LinkList;

import utils.ListNode;

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例 1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * 示例 2：
 * 输入：l1 = [], l2 = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *
 * 提示：
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 *
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 */
public class Problem_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        ListNode start = new ListNode();
        ListNode r = start;
        while (p != null && q != null) {
            if (p.val < q.val) {
                r.next = p;
                p = p.next;
                r = r.next;
            } else {
                r.next = q;
                q = q.next;
                r = r.next;
            }
        }
        if (p == null) {
            r.next = q;
        } else {
            r.next = p;
        }
        return start.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.buildList(new int[]{1,2,6});
        ListNode l2 = ListNode.buildList(new int[]{1,3,4});
        ListNode.showNodes(new Problem_21().mergeTwoLists(l1, l2));
    }
}
