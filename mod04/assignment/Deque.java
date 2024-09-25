import java.lang.Iterable;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Deque. it is a Doubly Linked List implemetation.
 * reference: https://coursera.cs.princeton.edu/algs4/assignments/queues/specification.php
 */
public class Deque<Item> implements Iterable<Item> {
    private int n;
    private Node first;
    private Node last;
    private class Node {
        Item item;
        Node prev;
        Node next;
    }
    private class DequeIterator implements Iterator<Item> {
        Node current = first;
        public boolean hasNext () {
            return current != null;
        }
        public Item next () {
            if (current == null) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
        public void remove () {
            throw new UnsupportedOperationException();
        }
    }
    public Deque () {
        this.n = 0;
        this.first = null;
        this.last = null;
    }
    public boolean isEmpty () {
        return this.n == 0;
    }
    public int size () {
        return this.n;
    }
    public void addFirst (Item item) {
        if (item == null) throw new IllegalArgumentException();
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        if (oldFirst == null) last = first;
        if (oldFirst != null) oldFirst.prev = first;
        this.n++;
    }
    public void addLast (Item item) {
        if (item == null) throw new IllegalArgumentException();
        Node lastNode = last;
        last = new Node();
        last.item = item;
        if (lastNode == null) {
            first = last;
        } else {
            lastNode.next = last;
            last.prev = lastNode;
        }
        this.n++;
    }
    public Item removeFirst () {
        if (this.isEmpty()) throw new NoSuchElementException();
        Item item = first.item;
        first = first.next;
        if (first == null) last = null;
        if (first != null) first.prev = null;
        this.n--;
        return item;
    }
    public Item removeLast () {
        if (this.isEmpty()) throw new NoSuchElementException();
        Item item = last.item;
        last = last.prev;
        if (last == null) first = null;
        if (last != null) last.next = null;
        this.n--;
        return item;
    }
    public Iterator<Item> iterator () {
        return new DequeIterator();
    }
    public static void main (String[] args) {
    }
}
