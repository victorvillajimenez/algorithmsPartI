import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Stack. A linked-list implementation, with iterator
 * 
 * Iteration. Support iteration over stack items by client, without revealing 
 * the internal representation of the stack.
 * 
 * What is an Iterable? Has a method that returns an Iterator.
 * What is an Iterator? Has methods hasNext() and next().
 * What make data structures Iterable? Java supports elegant client code.
 * 
 * shorthand:
 *  for (String s : stack) {
 *      System.out.println(s);
 *  }
 * 
 * longhand:
 *  Iterator<String> i = stack.iterator();
 *  while (i.hasNext()) {
 *      System.out.println(i.next());
 *  }
 */
public class IterableLinkedStack<Item> implements Iterable<Item> {
    private Node first;

    private class Node {
        Item item;
        Node next;
        public Node (Item item) {
            this.item = item;
            this.next = null;
        }
    }

    public boolean isEmpty () {
        return first == null;
    }

    public void push (Item item) {
        Node oldFirst = this.first;
        this.first = new Node(item);
        this.first.next = oldFirst;
    }

    public Item pop () {
        if (isEmpty()) throw new IllegalStateException("Empty Data structure");
        Item item = this.first.item;
        this.first = this.first.next;
        return item;
    }

    public Iterator<Item> iterator () {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext () {
            return current != null;
        }
        public void remove () {
            // Not supported
            throw new UnsupportedOperationException("remove is not supported");
        }
        public Item next () {
            if (current == null) throw new NoSuchElementException("No more items");
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
