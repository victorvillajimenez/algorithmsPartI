import java.util.Iterator;
import java.util.NoSuchElementException;

public class IterableFixedCapacityStack<Item> implements Iterable<Item> {
    private Item[] s;
    private int n = 0;

    public IterableFixedCapacityStack (int capacity) {
        this.s = (Item[]) new Object[capacity];
    }
    public boolean isEmpty () {
        return this.n == 0;
    }
    public void push (Item item) {
        if (this.n == this.s.length) throw new IndexOutOfBoundsException("Full Data structure");
        this.s[this.n++] = item;
    }
    public Item pop () {
        if (isEmpty()) throw new IllegalStateException("Empty Data structure");
        Item item = this.s[--this.n];
        this.s[this.n] = null;
        return item;
    }

    public Iterator<Item> iterator () {
        return new ArrayIterator ();
    }

    private class ArrayIterator implements Iterator<Item> {
        private int i = 0;
        public boolean hasNext () {
            return i < n;
        }
        public void remove () {
            // Not supported
            throw new UnsupportedOperationException("Remove is not supported");
        }
        public Item next () {
            if (i >= n) throw new NoSuchElementException("No more items");
            return s[i++];
        }
    }
}