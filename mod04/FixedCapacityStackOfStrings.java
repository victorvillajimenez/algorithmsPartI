/**
 * Considerations:
 *  - Overflow: throw exception if pop from an empty stack.
 *  - Underflow: use resizing array for array implementation.
 * 
 *  - Null items: It allows null items to be inserted.
 * 
 *  - Loitering: Holding a reference to an object when it is no longer needed.
 * 
 * Defect: Stack overflows when N exceeds capacity.
 */
public class FixedCapacityStackOfStrings {
    private String[] s;
    private int n = 0;

    public FixedCapacityStackOfStrings (int capacity) {
        this.s = new String[capacity];
    }
    public boolean isEmpty () {
        return this.n == 0;
    }
    public void push (String item) {
        // prevent stack overflows when N exceeds capacity
        if (this.n == this.s.length) throw new IndexOutOfBoundsException("Full data structure");
        this.s[this.n++] = item;
    }
    public String pop () {
        if (isEmpty()) throw new IllegalStateException("Empty data structure");
        // return this.s[--n]; // loitering
        // prevent loitering
        String item = this.s[--this.n];
        this.s[this.n] = null;
        return item;
    }
}
