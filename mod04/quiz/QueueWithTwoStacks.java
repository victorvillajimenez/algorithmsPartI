import java.util.NoSuchElementException;
/**
 * Stacks and Queues
 * 1. Queue with two stacks. Implement a queue with stacks so that each queue operation
 *    takes a constant amortized number of stack operations.
 * HINT: If you push elements onto a stack and then pop them all, they appear in reverse order.
 *       If you repeat the process, they're now back in order.
 */
public class QueueWithTwoStacks<T> {
    private Stack<T> in;
    private Stack<T> out;

    public QueueWithTwoStacks () {
        this.in = new Stack<T>();
        this.out = new Stack<T>();
    }
    // aka enqueue
    public void add (T data) {
        this.in.push(data);
    }
    // aka dequeue
    public T remove () {
        if (this.out.isEmpty()) {
            while (!this.in.isEmpty()) this.out.push(this.in.pop());
        }
        if (this.out.isEmpty()) throw new NoSuchElementException();
        return this.out.pop();
    }
    public int size () {
        return this.in.size() + this.out.size();
    }
    public boolean isEmpty () {
        return this.size() == 0;
    }

    private class Stack<T> {
        private T[] a;
        private int n;
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
        private void resize (int capacity) {
            T[] t = (T[]) new Object[capacity];
            for (int i = 0; i < this.a.length; i++) t[i] = this.a[i];
            this.a = t;
        }
    }
}
