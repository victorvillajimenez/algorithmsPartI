/**
2. Union-find with specific canonical element. Add a method find() to the union-find data type so that
find(i) returns the largest element in the connected component containing i.
The operations, union(), connected(), and find() should all take logarithmic time or better.

For example, if one of the connected components is {1,2,6,9},
then the find() method should return 9 for each of the four elements in the connected components.

Hint: maintain an extra array to the weighted quick-union data structure that
stores for each root i the large element in the connected component containing i.

UFQUPC = Union Quick Union With Path Compression.
For union function, always assigning the largest index to the smallest position element.
For find function, worst case it takes O(k) only once per all operations. where 'k' is the depth in a connected component.
 */
import edu.princeton.cs.algs4.StdIn;

//
// TODO: it's still incomplete!
//
public class UFQuickUnionWithPathCompression {
    private int[] a;

    public UFQuickUnionWithPathCompression (int n) {
        this.a = new int[n];
        for (int i = 0; i < n; i++) this.a[i] = i;
    }

    public int find (int i) {
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

    public boolean connected (int p, int q) {
        return find(p) == find(q);
    }

    public void union (int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        if (i < j) {
            this.a[i] = j;
        } else {
            this.a[j] = i;
        }
    }

    public static void main (String[] args) {
        int n = StdIn.readInt();
        UFQuickUnionWithPathCompression qupc = new UFQuickUnionWithPathCompression(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!qupc.connected(p, q)) qupc.union(p, q);
        }
    }
}
