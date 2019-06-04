package link;

import data.Node;

/**
 * 链表反转
 */
public class ReverseLink {

    /**
     * 借助一个节点实现，主要采用的是头插法
     * @param head
     * @return
     */
    public static Node reverseLink1(Node head) {
        Node pre = null;
        Node next;
        while(head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static Node reverseLink2(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node pre = head, cur = head, next = head.next;
        while(next != null) {
            cur = next;
            next = cur.next;
            cur.next = pre;
            pre = cur;
        }
        head.next = null;
        return pre;
    }
}
