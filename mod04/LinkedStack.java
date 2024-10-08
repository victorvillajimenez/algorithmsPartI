/**
 * Generics.
 * 
 * - Generics vs Data Structure Implementation with elements of type Object
 *    - Data Structure Implementation:
 *        - Casting is required in client.
 *        - Casting is error-prone: run-time error if types mismatch.
 *    - Generics:
 *        - Avoid casting in client.
 *        - Discover type mismatch error at compile-time instead of run-time.
 */
public class LinkedStack<Item> {
    private Node first = null;
    private class Node {
        public Node (Item item) {
            this.item = item;
            this.next = null;
        }
        Item item;
        Node next;
    }
    public boolean isEmpty () {
        return this.first == null;
    }
    public void push (Item item) {
        Node oldFirst = this.first;
        this.first = new Node(item);
        this.first.next = oldFirst;
    }
    public Item pop () {
        Item item = this.first.item;
        this.first = this.first.next;
        return item;
    }
}