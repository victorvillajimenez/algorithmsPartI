/**
 * Tradeoffs:
 *  - Use extra time and space to deal with the links.
 * Propositions:
 *  - Every operation takes constant time in the worst case.
 *  - A stack with N items uses ~40 N bytes.
 *     - 16 bytes (object overhead)
 *     -  8 bytes (iner class object overhead)
 *     -  8 bytes (reference to String -> item)
 *     -  8 bytes (refeence to Node -> next)
 */
public class LinkedStackOfStrings {
    private Node first = null;
    private class Node {
        public Node (String item) {
            this.item = item;    
        }
        String item;
        Node next;
    }
    public boolean isEmpty () {
        return first == null;
    }
    public void push (String item) {
        Node oldFirst = first;
        first = new Node(item);
        first.next = oldFirst;
    }
    public String pop () {
        String item = first.item;
        first = first.next;
        return item;
    }
}
