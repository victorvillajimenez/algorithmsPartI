/**
3. Successor with delete. Given a set of n integers S={0,1,...,n−1} and
a sequence of requests of the following form:

* Remove x from S
* Find the successor of x: the smallest y in S such that y≥x.

design a data type so that all operations (except construction)  take logarithmic time or better in the worst case.

Hint: use the modification of the union−find data discussed in the previous question.
 */
public class UFSuccessorWithDelete {
    private int[] a;
    private int[] next;
    private int[] sz;

    public UFSuccessorWithDelete (int n) {
        this.a = new int[n];
        this.next = new int[n];
        this.sz = new int[n];
        for (int i = 0; i < n; i++) {
            this.a[i] = i;
            this.next[i] = i;
            this.sz[i] = 1;
        }
    }
    public int root (int i) {
        int r = i;
        while (r != this.a[r]) {
            r = this.a[r];
        }
        while (r != this.a[i]) {
            int t = this.a[i];
            this.a[i] = r;
            i = t;
        }
        return r;
    }
    public void union (int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j) return;
        if (this.sz[i] < this.sz[j]) {
            this.a[i] = j;
            this.sz[j] += this.sz[i];
            this.next[j] = Math.max(this.next[i], this.next[j]);
        } else {
            this.a[j] = i;
            this.sz[i] += this.sz[j];
            this.next[i] = Math.max(this.next[i], this.next[j]);
        }
    }
    public int find (int i) {
        if (i == this.a.length - 1) throw new ArrayIndexOutOfBoundsException("There is no succesor for " + i);
        return this.next[root(i + 1)];
    }
    public void delete (int i) {
        if (i == this.a.length - 1) throw new ArrayIndexOutOfBoundsException("Restriction : " + i);
        union(i, i + 1);
    }
    public void showData () {
        System.out.println("Show Data");
        for (int i = 0; i < this.a.length; i++)
            System.out.println(i + " : " + this.a[i] + " - " + this.sz[i] + " - " + this.next[i]);
    }
    public static void main (String[] args) {
        System.out.println("UFSuccessorWithDelete");
        UFSuccessorWithDelete swd = new UFSuccessorWithDelete(10);
        swd.delete(8);
        swd.delete(7);
        System.out.println(swd.find(4));
        swd.delete(5);
        swd.delete(6);
        swd.delete(7);
        swd.delete(7);
        swd.showData();
        System.out.println(swd.find(4));
        System.out.println(swd.find(6));
        System.out.println(swd.find(7));
        System.out.println(swd.find(3));
        System.out.println(swd.find(8));
    }
}
