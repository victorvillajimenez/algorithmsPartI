public class LinkedQueueOfStrings {
    private Node first;
    private Node last;
    private class Node {
        private String item;
        private Node next;
        public Node (String item) {
            this.item = item;
            this.next = null;
        }
    }
    public boolean isEmpty () {
        return this.first == null;
    }
    public void enqueue (String item) {
        Node old = this.last;
        this.last = new Node(item);
        if (isEmpty()) {
            this.first = this.last;
        } else {
            old.next = this.last;
        }
    }
    public String dequeue () {
        if (isEmpty()) throw new IllegalStateException("Empty Data structure");
        String item = this.first.item;
        this.first = this.first.next;
        if (isEmpty()) this.last = null;
        return item;
    }
}
