/**
 * Generic data types: Autoboxing
 *  - Each primitive type has a wrapper object type
 *  - Autoboxing, automatic cast between a primitive type and its wrapper.
 *    Examples:
 *      - s.push(12); -> s.push(Integer.valueOf(12));
 *      - int a = s.pop(); -> int a = s.pop().intValue();
 */
public class FixedCapacityStack<Item> {
    private Item[] s;
    private int n = 0;
    public FixedCapacityStack (int capacity) {
        // this.s = new Item[capacity]; // Generic array creation not allowed in Java
        this.s = (Item[]) new Object[capacity]; // ugly cast, but it fixes
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
}