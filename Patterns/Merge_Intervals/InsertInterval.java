import java.util.*;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
};

class InsertInterval {

    /*
     * Givien a list of non-overlapping intervals sorted by their start time, insert  a given interval
     * at the correct position and merge all necessary intervals to produce a list that has only
     * mutually exlusive intervals
     *
     * Example 1: Input = [[1, 3], [5, 7], [8, 12]], new interval = [4,6]
     * Output: [[1,3], [4,7], [8,1]]
     */
    public static List<Interval> insertBF(List<Interval> intervals, Interval newInterval) {
        List<Interval> mergedIntervals = new ArrayList<>();
        Iterator<Interval> intervalItr = intervals.iterator();
        Interval current = intervalItr.next();
        while (intervalItr.hasNext() && current.end < newInterval.start) {
            mergedIntervals.add(new Interval(current.start, current.end));
            current = intervalItr.next();
        }
        int start = Math.min(current.start, newInterval.start);
        int end = Math.max(current.end, newInterval.end);
        while (intervalItr.hasNext() && current.start <= end) {
            end = Math.max(current.end, newInterval.end);
            current = intervalItr.next();
        }
        mergedIntervals.add(new Interval(start, end));
        mergedIntervals.add(new Interval(current.start, current.end));
        while (intervalItr.hasNext()) {
            current = intervalItr.next();
            mergedIntervals.add(new Interval(current.start, current.end));
        }
        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(4, 6)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(4, 10)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(2, 3));
        input.add(new Interval(5, 7));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(1, 4)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}
