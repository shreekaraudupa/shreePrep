package day1.setMatrixZeros;

/*
UNROLLED LINKED LIST
-Instead of just storing 1 element at each node, unorlled linked list stores an entire array in each node
-Unrolled linked list combines the advantage of an array (low memory overhead) with the advantage of linked lists (rapid insertions and deletion) to achieve dramatically improved performance.

https://www.geeksforgeeks.org/unrolled-linked-list-set-1-introduction/

LinkedList holding character arrays
head:- [] -> [] -> [] -> [] -> null
      1-a   4-d   6-e   9-j
      2-b   5-f   7-k   10-o
      3-c         8-l   11-m
*/

public class JoveoRound1 {
    public static void main(String[] args) {
        Solution4 s = new Solution4();
        System.out.println(s.find(s.buildLL(), 8));
    }
}

class Solution4 {

    public char find(Node head, int position) {
        int positionCount = 0;
        int positionOffset = 0;
        char output = 0;
        while (head.next != null) {
            if (positionCount == 0 && position <= head.noOfElements) {
                output = head.elements[position - 1];
                break;
            }
            if (position <= positionCount + head.noOfElements) {
                positionOffset = position - positionCount;
                output = head.elements[positionOffset - 1];
                break;
            }
            positionCount = positionCount + head.noOfElements;
            head = head.next;
        }
        return output;
    }

    Node buildLL() {
        char[] c1 = new char[]{'a', 'b', 'c'};
        char[] c2 = new char[]{'d', 'f'};
        char[] c3 = new char[]{'e', 'k', 'l'};
        char[] c4 = new char[]{'j', 'o', 'm'};

        Node n = new Node(c1, c1.length);
        Node n1 = new Node(c2, c2.length);
        Node n2 = new Node(c3, c3.length);
        Node n3 = new Node();
        Node n4 = new Node(c4, c4.length);

        n.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;

        return n;
    }
}


class Node {
    Node next;
    char[] elements;
    int noOfElements;

    Node(char[] elements, int noOfElements) {
        this.elements = elements;
        this.noOfElements = noOfElements;
    }
    Node() {
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public char[] getElements() {
        return elements;
    }
    public void setElements(char[] elements) {
        this.elements = elements;
    }
    public int getNoOfElements() {
        return noOfElements;
    }
    public void setNoOfElements(int noOfElements) {
        this.noOfElements = noOfElements;
    }
}
