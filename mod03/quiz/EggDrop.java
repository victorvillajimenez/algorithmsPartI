/*
    Analysis of Algorithms
    3. Egg drop.
    Suppose that you have an n-story building (with floors 1 through n) and 
    plenty of eggs. An egg breaks if it is dropped from floor T or higher and
    does not break otherwise. Your goal is to devise a strategy to determine 
    the value of T given the following limitations on the number of eggs and tosses:
    - Version 0: 1 egg, <= T tosses
    - Version 1: ~ 1 lg N eggs and ~ 1 log N tosses
    - Version 2: ~ 1 lg T eggs and ~ 2 lg T tosses
    - Version 3: 2 eggs and ~ 2 sqrt(N) tosses
    - Version 4: 2 eggs and <= C sqrt(T) tosses for some fixed constant C
*/
public class EggDrop {

    public static void main (String[] args) {
        boolean[] a = new boolean[100];
        int k = (int) (Math.random() * 100);
        System.out.println("K :" + k);
        for (int i = 0; i < k; i++) a[i] = true;
        System.out.println("EggDrop.oneEgg(a): " + EggDrop.oneEgg(a));
        System.out.println("EggDrop.sameEggsAndTosses(a): " + EggDrop.sameEggsAndTosses(a));
        System.out.println("EggDrop.eggDoubleTosses(a): " + EggDrop.eggDoubleTosses(a));
        System.out.println("EggDrop.twoEggsTwoSqrtNTosses(a): " + EggDrop.twoEggsTwoSqrtNTosses(a));
        System.out.println("EggDrop.twoEggsSqrtTTosses(a) :  TODO implementation.");
    }

    // Version 0: 1 egg, <= T tosses
    // Hint: sequential search.
    public static int oneEgg (boolean[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == false) return i + 1;
        }
        return a.length;
    }

    // Version 1: ~ 1 lg N eggs and ~ 1 log N tosses
    // Hint: binary search.
    public static int sameEggsAndTosses (boolean[] a) {
        int start = 1;
        int end = a.length - 2;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (a[mid] == true && a[mid + 1] == false) {
                return mid + 2;
            } else if (a[mid] == false && a[mid - 1] == true) {
                return mid + 1;
            } else if (a[mid] == true) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return a[0] == false ? 1 : a.length;
    }

    // Version 2: ~ 1 lg T eggs and ~ 2 lg T tosses
    // Hint: find an interval containing T of size ≤ 2T, then do binary search.
    public static int eggDoubleTosses (boolean[] a) {
        int start = 0;
        int end = a.length - 1;
        int mid = start + (end - start) / 2;
        if (a[mid] == true) {
            start = mid + 1;
            end--;
        } else {
            end = mid - 1;
            start++;
        }
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (a[mid] == true && a[mid + 1] == false) {
                return mid + 2;
            } else if (a[mid] == false && a[mid - 1] == true) {
                return mid + 1;
            } else if (a[mid] == true) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return a[0] == false ? 1 : a.length;
    }

    // Version 3: 2 eggs and ~ 2 sqrt(N) tosses
    // Hint: find an interval of size sqrt(n), then do sequential search.
    // Note: can be improved to ∼ sqrt(2N) tosses.
    public static int twoEggsTwoSqrtNTosses (boolean[] a) {
        int interval = (int) Math.sqrt(a.length * 2);
        int i = 0;
        boolean firstEggBroken = false;
        for (i = 1; i * interval < a.length; i += 2) {
            int idxBase = i * interval;
            for (int j = 0; j < interval; j++) {
                int idx = idxBase + j;
                if (a[idx] == false) {
                    if (j == 0) {
                        firstEggBroken = true;
                        break;
                    }
                    return idx + 1;
                }
            }
            if (firstEggBroken) break;
        }
        if (firstEggBroken) {
            for (int j = 0; j < interval; j++) {
                int idx = (i - 1) * interval + j;
                if (a[idx] == false) return idx + 1;
            }
            return i * interval + 1;
        }
        return a.length;
    }

    // Version 4: 2 eggs and <= C sqrt(T) tosses for some fixed constant C
    // Hint: 1 + 2 + 3 + ... + t ~ 1/2 t^2. Aim for c = 2 sqrt(2).
    public static int twoEggsSqrtTTosses (boolean[] a) {
        return a.length;
    }
}
