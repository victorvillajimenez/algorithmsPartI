import java.lang.Iterable;
import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;
/**
 * RandomizedQueue. it is a Doubly Linked List implementation.
 * reference: https://coursera.cs.princeton.edu/algs4/assignments/queues/specification.php
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private int n;
    private Node first;
    private Node last;
    private class Node {
        Item item;
        Node prev;
        Node next;
    }
    private class RandomizedQueueIterator implements Iterator<Item> {
        Node current;
        boolean isAsc;
        public RandomizedQueueIterator () {
            this.isAsc = StdRandom.uniformInt(2) == 1;
            this.current = isAsc ? first : last;
        }
        public boolean hasNext () {
            return current != null;
        }
        public Item next () {
            if (current == null) throw new NoSuchElementException();
            Item item = current.item;
            current = isAsc ? current.next : current.prev;
            return item;
        }
        public void remove () {
            throw new UnsupportedOperationException();
        }
    }
    public RandomizedQueue () {
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
    public void enqueue (Item item) {
        if (item == null) throw new IllegalArgumentException();
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (oldLast == null) {
            first = last;
        } else {
            oldLast.next = last;
            last.prev = oldLast;
        }
        this.n++;
    }
    public Item dequeue () {
        if (isEmpty()) throw new NoSuchElementException();
        Item item;
        if (this.n == 1) {
            item = first.item;
            first = null;
            last = null;
            this.n--;
            return item;
        }
        int index = StdRandom.uniformInt(this.n);
        Node cur = first;
        for (int i = 0; i < index; i++) cur = cur.next;
        item = cur.item;
        if (cur.next == null) { // means cur is the last
            cur.prev.next = null;
            last = cur.prev;
        } else {
            // if cur is not the first, join prev with next
            if (cur.prev != null) cur.prev.next = cur.next;
        }
        if (cur.prev == null) { // means cur is the first
            cur.next.prev = null;
            first = cur.next;
        } else {
            // if cur is not the last, join next with prev
            if (cur.next != null) cur.next.prev = cur.prev;
        }
        this.n--;
        return item;
    }
    public Item sample () {
        if (this.isEmpty()) throw new NoSuchelementException();
        if (this.n == 1) return first.item;
        int index = StdRandom.uniformInt(this.n);
        Node cur = first;
        for (int i = 0; i < index; i++) cur = cur.next;
        return cur.item;
    }
    public Iterator<Item> iterator () {
        return new RandomizedQueueIterator();
    }
    public static void main (String[] args) {
    }
}
