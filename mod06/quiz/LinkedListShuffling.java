/*
Module 06 - Interview Questions: Mergesort

3.- Shuffling a linked list.
Given a singly-linked list cointaining n items, rearrange the items uniformly at random.
Your algorithm should consume a logarithmic (or constant) amount of extra memory and run
in time proportional to n log n in the worst case.
HINT: design a linear-time subroutine that can take two uniformly shuffled linked lists of
sizes n1 and n2 and combined them into a uniformly shuffled linked lists of size n1 + n2
*/
import java.util.Random;
public class LinkedListShuffling {
    private int size;
    private Node root;
    private class Node {
        public int value;
        public Node next;
        public Node (int value) {
            this.value = value;
        }
    }
    public LinkedListShuffling (int size) {
        this.size = size;
        this.root = this.generateLinkedList();
    }
    public static void main (String[] args) {
        LinkedListShuffling ll = new LinkedListShuffling(100);
        ll.shuffle();
    }
    public void shuffle () {
        Random random = new Random();
        Node cur = root;
        for (int i = 1; i < this.size; i++) {
            int r = random.nextInt(i + 1);
            if (r == i) {
                if (cur.next != null) cur = cur.next;
            } else if (r == 0) {
                Node iNode = cur.next;
                if (cur.next != null) cur.next = cur.next.next;
                iNode.next = root;
                root = iNode;
            } else {
                Node iNode = cur.next;
                if (cur.next != null) cur.next = cur.next.next;
                Node rNodePrev = root;
                for (int j = 1; j < r; j++) rNodePrev = rNodePrev.next;
                if (cur == rNodePrev.next) {
                    rNodePrev.next = iNode;
                    iNode.next = cur;
                } else {
                    Node rNode = rNodePrev.next;
                    if (rNodePrev.next != null) rNodePrev.next = rNodePrev.next.next;
                    rNode.next = cur.next;
                    cur.next = rNode;
                    iNode.next = rNodePrev.next;
                    rNodePrev.next = iNode;
                    if (cur.next != null) cur = cur.next;
                }
            }
        }
    }
    public Node generateLinkedList () {
        Node root = null;
        for (int i = this.size; i > 0; i--) {
            Node old = root;
            root = new Node(i);
            root.next = old;
        }
        return root;
    }
}
