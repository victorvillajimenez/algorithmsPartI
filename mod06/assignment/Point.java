/**
 * Programming assigment 3: Collinear Points - Mergesort
 * https://coursera.cs.princeton.edu/algs4/assignments/collinear/specification.php
 * collinear.zip that contains Point.java, BruteCollinearPoints.java and FastCollinearPoints.java
 */
import java.util.Comparator;
import edu.princeton.cs.algs4.StdDraw;
public class Point implements Comparable<Point> {
    private final int x;
    private final int y;
    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void draw () {
        StdDraw.point(x, y);
    }
    public void drawTo (Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }
    public String toString () {
        return "(" + x + ", " + y + ")";
    }
    /**
     * Compares two points by y-coordinate, breaking ties by x-coordinate.
     * Formally, the invoking point (x0, y0) is less than the argument point
     * (x1, y1) if and only if either y0 < y 1 or if y0 = y1 and x0 < x1.
     * 
     * @param that the other point
     * @return <tt>0</tt> if this point is equal to that point (x0 = x1 and y0 = y1);
     *         a negative integer if this point is less than that point;
     *         a positive integer if this point is greater than that point
     */
    public int compareTo (Point that) {
        if (this.y < that.y) return -1;
        if (this.y > that.y) return 1;
        if (this.x < that.x) return -1;
        if (this.x > that.x) return 1;
        return 0;
    }
    /**
     * Returns the slope between this point and the specified point that.
     * Formally, if the two points are (x0, y0) and (x1, y1), then the slope
     * is (y1 - y0) / (x1- x0). For completeness, the slope is defined to be
     * +0.0 if the line segment connecting the two points is horizontal;
     * Double.POSITIVE_INFINITY if the line segment is vertical;
     * Double.NEGATIVE_INFINITY if (x0, y0) and (x1, y1) are igual.
     * 
     * @param that the other point
     * @return the slope between this point and the specified point
     */
    public double slopeTo (Point that) {
        int value = this.compareTo(that);
        if (value == 0) return Double.NEGATIVE_INFINITY; // Both points are in the same location
        int divisor = that.x - this.x;
        if (divisor == 0) return Double.POSITIVE_INFINITY; // line is Vertical
        int dividend = that.y - this.y;
        double res = dividend / (double) divisor;
        if (Math.abs(res) == 0.0) return Math.abs(res); // if result is 0.0 means line is Horizontal
        return res;
    }
    /**
     * Compares two points by the slope they make with this point.
     * The slope is defined as in the slopeTo() method.
     * 
     * @return the Comparator that defines this ordering on points.
     */
    public Comparator<Point> slopeOrder () {
        return new SlopeOrderComparator();
    }
    private class SlopeOrderComparator implements Comparator<Point> {
        public int compare (Point a, Point b) {
            if (a.compareTo(b) == 0) return 0;
            double slopeA = Point.this.slopeTo(a);
            double slopeB = Point.this.slopeTo(b);
            if (slopeA == Double.NEGATIVE_INFINITY && slopeB == Double.NEGATIVE_INFINITY) return 0;
            if (slopeA == Double.NEGATIVE_INFINITY) return -1;
            if (slopeB == Double.NEGATIVE_INFINITY) return 1;
            if (slopeA == Double.POSITIVE_INFINITY && slopeB == Double.POSITIVE_INFINITY) return 0;
            if (slopeA == 0.0 && slopeB == 0.0) return 0;
            return Double.compare(slopeA, slopeB);
        }
    }
}