package leet100;

/*
*  Alternate the linked list
*  https://leetcode.com/problems/odd-even-linked-list/
*
* */

public class JSWRound1 {
    public static void main(String[] args) {
        SolutionOddEvenLL s = new SolutionOddEvenLL();
        s.oddEvenList(s.buildLL());
    }

}

class SolutionOddEvenLL {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode tmp = evenNode;
        while (evenNode != null && evenNode.next != null) {
            oddNode.next = evenNode.next;
            oddNode = oddNode.next;
            evenNode.next = oddNode.next;
            evenNode = evenNode.next;
        }

        oddNode.next = tmp;
        return head;
    }


    public ListNode buildLL() {
        ListNode l5 = new ListNode(5, null);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        return l1;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {
    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}