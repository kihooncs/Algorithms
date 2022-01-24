import java.util.*;

class MergeIntervals {
    class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    };
    /*
     *
     *
     */
    public static List<Interval> mergeBF(List<Interval> intervals) {
        // At most O(n) space at worst case.
        List<Interval> mergedIntervals = new LinkedList<Interval>();
        // O(nlogn) for sorting
        // Java's collections.sort() either uses Merge sort or Timsort, and both these algorithms
        // need O(N) space. Overall, our algorithm has a space complexity of O(N)
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        Interval a = intervals.get(0);
        Interval c = new Interval(a.start, a.end);
        // O(n) for traversing
        for (int i = 1; i < intervals.size(); i++) {
            Interval b = intervals.get(i);
            if (b.start <= c.end) {
                c.end = Math.max(b.end, c.end);
            } else {
                mergedIntervals.add(c);
                c = new Interval(b.start, b.end);
            }
        }
        mergedIntervals.add(c);
        return mergedIntervals;
    }

    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 2)
            return intervals;

        // sort the intervals by start time
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        List<Interval> mergedIntervals = new LinkedList<Interval>();
        Iterator<Interval> intervalItr = intervals.iterator();
        Interval interval = intervalItr.next();
        int start = interval.start;
        int end = interval.end;

        while (intervalItr.hasNext()) {
            interval = intervalItr.next();
            if (interval.start <= end) { // overlapping intervals, adjust the 'end'
                end = Math.max(interval.end, end);
            } else { // non-overlapping interval, add the previous interval and reset
                mergedIntervals.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        // add the last interval
        mergedIntervals.add(new Interval(start, end));

        return mergedIntervals;
    }

    public static void main(String[] args) {
        bruteForce();
        solution();
    }

    public static void bruteForce() {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.mergeBF(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.mergeBF(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.mergeBF(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}