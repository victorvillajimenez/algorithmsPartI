/**
 * Programming assigment 3: Collinear Points - Mergesort
 * https://coursera.cs.princeton.edu/algs4/assignments/collinear/specification.php
 * collinear.zip that contains Point.java, BruteCollinearPoints.java and FastCollinearPoints.java
 */
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
// import edu.princeton.cs.algs4.StdOut;
// import edu.princeton.cs.algs4.In;
// import edu.princeton.cs.algs4.StdDraw;
public class FastCollinearPoints {
    private LineSegment[] segments;
    public FastCollinearPoints (Point[] points) {
        // Coming soon!
    }
    private Point[] copyAndSortPoints (Point[] points, int start, Point p) {
        // Coming soon!
        return null;
    }
    public int numberOfSegments () {
        return segments.length;
    }
    public LineSegment[] segments () {
        LineSegment[] copy = new LineSegment[segments.length];
        for (int i = 0; i < segments.length; i++) copy[i] = segments[i];
        return copy;
    }
    public static void main (String[] args) {
        // read the n points from a line
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[100];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(in.readInt(), in.readInt());
        }
        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) p.draw();
        StdDraw.show();
        // print and draw the lines segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment s : collinear.segments()) {
            StdOut.println(s.toString());
            s.draw();
        }
        StdDraw.show();
    }
}
