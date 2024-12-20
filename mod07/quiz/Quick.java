/**
 * Module 7 - Interview Questions: Quicksort
 * 
 * 1. Nuts and bolts. A disorganized carpenter has a mixed pile of n nuts and n bolts.
 *    The goal is to find the corresponding pairs of nuts and bolts. Each nut fits exactly
 *    one bolt and each bolt fits exactly one nut. By fitting a nut and a bolt together,
 *    the carpenter can see which one is bigger (but the carpenter cannot compare two nuts
 *    or two bolts directly). Design an algorithm for the problem that uses at most proportional
 *    to n log n compares (probabilistically).
 * 
 *    ANSWER:
 *    // Coming soon
 * 
 *    HINT: modify the quicksort partitioning part of quicksort.
 *          https://web.cs.ucla.edu/~rafail/PUBLIC/17.pdf gives an
 *          algorithm that runs in n log^4 n time in the worst case.
 * 
 * 2. Selection in two sorted arrays. Given two sorted arrays a[] and b[], of lengths n1 and n2
 *    and an integer 0 <= k < n1 + n2, design an algorithm to find a key of rank k. The order of growth
 *    of the worst case running time of your algorithm should be log n, where n = n1 + n2
 *    - Version 1: n1 = n2 (equal length arrays) and k = n / 2 (median).
 *    - Version 2: k = n / 2 (median).
 *    - Version 3: no restrictions.
 * 
 *    // Coming soon
 * 
 *    HINT: there are two basic approaches.
 *          - Approach A: Compute the median in a[] and the median in b[].
 *                        Recur in a subproblem of roughly half the size.
 *          - Approach B: Design a constant-time algorithm to determine whether
 *                        a[i] is a key of rank k. Use this subrutine and binary search.
 *          Dealing with corner cases can be tricky.
 * 
 * 3. Decimal dominants. Given an array with n keys, design an algorithm to find all values
 *    that occur more than n / 10 times. The expected running time of your algorithm should be linear
 * 
 *    // Coming soon
 * 
 *    HINT: determine the (n / 10)^th largest key using quickselect and check if it occurs more than
 *          n / 10 times. Alternate solution hint: use 9 counters.
 */
public class Quick {

}
