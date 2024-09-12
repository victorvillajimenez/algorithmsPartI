import edu.princeton.cs.algs4.WeightedQuickUnionUF;
/**
 * reference: https://coursera.cs.princeton.edu/algs4/assignments/percolation/specification.php
 */
public class Percolation {
    private boolean[][] a;
    private int openSites;
    private int top;
    private int bottom;
    private WeightedQuickUnionUF uf;

    public Percolation (int n) {
        if (n <= 0) throw new IllegalArgumentException("Out of limits");
        this.a = new boolean[n][n];
        this.openSites = 0;
        this.top = 0;
        this.bottom = n * n + 1;
        this.uf = new WeightedQuickUnionUF(n * n + 2);
    }

    public void open (int row, int col) {
        if (!this.isInModel(row, col)) throw new IllegalArgumentException("Out of limits");
        if (this.isOpen(row, col)) return;
        this.a[row - 1][col - 1] = true;
        int p = this.toLinear(row, col);
        if (row == 1) this.uf.union(this.top, p);
        if (row == this.a.length) this.uf.union(p, this.bottom);

        if (this.isOpenNeighbor(row - 1, col)) this.uf.union(this.linear(row - 1, col), p);
        if (this.isOpenNeighbor(row + 1, col)) this.uf.union(p, this.linear(row + 1, col));
        if (this.isOpenNeighbor(row, col - 1)) this.uf.union(this.linear(row, col - 1), p);
        if (this.isOpenNeighbor(row, col + 1)) this.uf.union(p, this.linear(row, col + 1));

        this.openSites++;
    }

    public boolean isFull (int row, int col) {
        if (!this.isInModel(row, col)) throw new IllegalArgumentException("Out of limits");
        if (!this.isOpen(row, col)) return false;
        int p = this.toLinear(row, col);
        return this.uf.find(this.top) == this.uf.find(p);
    }

    private boolean isInModel (int row, int col) {
        return row > 0 && row <= this.a.length && col > 0 && col <= this.a.length;
    }
    public boolean isOpen (int row, int col) {
        if (!this.isInModel(row, col)) throw new IllegalArgumentException("Out of limits");
        return this.a[row - 1][col - 1];
    }
    public int toLinear (int row, int col) {
        return (row - 1) * this.a.length + col;
    }
    public boolean isOpenNeighbor (int row, int col) {
        return this.isInModel(row, col) && this.isOpen(row, col);
    }

    public int numberOfOpenSites () {
        return this.openSites;
    }

    public boolean percolates () {
        return this.uf.find(this.top) == this.uf.find(this.bottom);
    }

    public static void main (String[] args) {
        Percolation percolation = new Percolation(3);
        p.open(1, 3);
        p.open(2, 3);
        p.open(3, 3);
        p.open(3, 1);
        // Should be FALSE, but it returns TRUE since there is a union btw a[3,1] and bottom
        // and there is a union or percolation btw bottom and top
        System.out.println("It is full (3, 1): " + p.isFull(3, 1));
        p.showModel();
    }

    public void showModel () {
        System.out.println("Open sites: " + this.openSites);
        for (int i = 0; i < this.a.length; i++) {
            for (int j = 0; j < this.a.length; j++) {
                System.out.print(" " + (this.a[i][j] ? 1 : 0));
            }
            System.out.println("");
        }
    }
}