package com.guo;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表
 * @author gsf
 * @date 2020/6/24 16:20
 */
public class LC141 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> vals = new HashSet<ListNode>();
        while (head != null) {
            if (vals.contains(head))
                return true;
            else {
                vals.add(head);
                head = head.next;
            }
        }
        return false;
    }


    public boolean hasCycle2(ListNode head){
        if(head == null || head.next == null)
            return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while (slow != fast){
            if(fast == null || fast.next == null) // 当快的游标跑到链表尾 说明没有环
                return false;
            fast = fast.next.next; // 只能移动两个结点，否则会跳过慢的游标
            slow = slow.next;
        }
        return true; // 循环结束 意味着快的游标追上慢的游标 存在环
    }
}
