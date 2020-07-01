package com.guo;

/**
 * 链表反转
 *
 * @author gsf
 * @date 2020/6/24 15:57
 */
public class LC206 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode reverseList1(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode listNode = reverseList1(head.next);
        head.next.next = head;
        head.next=null;
        return listNode;
    }

}
