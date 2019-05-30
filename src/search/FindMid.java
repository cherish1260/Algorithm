package search;

import data.Node;

public class FindMid {

    /**
     * 找一个链表的中间
     * @param first
     */
    public static void FindMid(Node first) {
        Node fast = first;
        Node slow = first;
        while ((fast != null) && (fast.next != null)) {
            fast = fast.next.next;
            if (fast == null) {
                break;
            }
            slow = slow.next;
        }
        System.out.println(slow.getI());
    }
}
