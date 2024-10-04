import java.util.NoSuchElementException;
/**
 * Stacks and Queues
 * 2. Stack with max. Create a data structure that efficiently supports the stack operations
 *     (push and pop) and also a return-the-maximum operation. Assume the elements are real numbers
 *     so that you can compare them.
 * HINT: Use two stacks, one to store all of the items and a second stack to store the maximums.
 */
public class StackWithMax extends Stack<Integer> {
    private Stack<Integer> max;

    public StackWithMax () {
        super();
        this.max = new Stack<Integer>();
    }
    public Integer max () {
        if (this.isEmpty()) throw new NoSuchElementException();
        return this.max.peek();
    }
    public void push (Integer data) {
        if (this.isEmpty() || data.compareTo(this.max.peek()) >= 0) this.max.push(data);
        super.push(data);
    }
    public Integer pop () {
        if (this.isEmpty()) throw new NoSuchElementException();
        Integer e = super.pop();
        if (e == this.max.peek()) this.max.pop();
        return e;
    }
}

class Stack<T> {
    private int n;
    private T[] a;

    public Stack () {
        this.n = 0;
        this.a = (T[]) new Object[1];
    }
    public int size () {
        return this.n;
    }
    public boolean isEmpty () {
        return this.n == 0;
    }
    public void push (T data) {
        this.a[this.n++] = data;
        if (this.n == this.a.length) resize(this.a.length * 2);
    }
    public T pop () {
        if (this.isEmpty()) throw new NoSuchElementException();
        T e = this.a[--this.n];
        this.a[this.n] = null;
        if (this.n > 0 && this.n == this.a.length / 4) resize(this.a.length / 2);
        return e;
    }
    public T peek () {
        if (this.isEmpty()) throw new NoSuchElementException();
        return this.a[this.n - 1];
    }
    private void resize (int capacity) {
        T[] t = (T[]) new Object[capacity];
        for (int i = 0; i < this.a.length; i++) t[i] = this.a[i];
        this.a = t;
    }
}
