/**
 * Tradeoffs:
 *  - Every operation tale constant amortized time
 *  - Less wasted space compared with LinkedList Stack
 * Resizing efficient solution:
 *  - for push, double size when array is full
 *  - for pop, halve size whe array is one-quarter full
 */
public class ResizingArrayStackOfStrings {
    private String[] s;
    private int n = 0;

    public ResizingArrayStackOfStrings () {
        this.s = new String[1];
    }

    public boolean isEmpty () {
        return this.n == 0;
    }

    public void push (String item) {
        if (this.n == this.s.length) resize(2 * s.length);
        this.s[this.n++] = item;
    }

    public String pop () {
        if (isEmpty()) throw new IllegalStateException("Empty data structure");
        String item = this.s[--this.n];
        this.s[n] = null;
        if (this.n > 0 && this.n == this.s.length / 4) resize(s.length / 2);
        return item;
    }

    private void resize (int capacity) {
        String[] copy = new String[capacity];
        for (int i = 0; i < this.s.length; i++) copy[i] = this.s[i];
        this.s = copy;
    }
}