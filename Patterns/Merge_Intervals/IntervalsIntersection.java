package Patterns.Merge_Intervals;

import java.util.*;

public class IntervalsIntersection {

    /*
     * Given two lists of intervals, find the intersection of these two lists.
     * Each list consists of disjoint intervals sorted on their start time.
     *
     * Example 1:
     * Input: arr1=[[1, 3], [5, 6], [7, 9]], arr2=[[2, 3], [5, 7]]
     * Output: [2, 3], [5, 6], [7, 7]
     * Explanation: The output list contains the common intervals between the two lists.
     *
     * Example 2:
     * Input: arr1=[[1, 3], [5, 7], [9, 12]], arr2=[[5, 10]]
     * Output: [5, 7], [9, 10]
     * Explanation: The output list contains the common intervals between the two lists.
     */
    public static Interval[] mergeBF(Interval[] arr1, Interval[] arr2) {
        List<Interval> intervalsIntersection = new ArrayList<Interval>();
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            Interval curr1 = arr1[i];
            Interval curr2 = arr2[j];
            if ((curr1.end >= curr2.start && curr2.start >= curr1.start)
                    || (curr2.end >= curr2.start && curr2.end <= curr1.end)) {
                int start = Math.max(curr1.start, curr2.start);
                int end = Math.min(curr1.end, curr2.end);
                intervalsIntersection.add(new Interval(start, end));
            }
            if (curr1.end >= curr2.end) {
                j++;
            } else {
                i++;
            }
        }
        return intervalsIntersection.toArray(new Interval[intervalsIntersection.size()]);
    }

    public static Interval[] merge(Interval[] arr1, Interval[] arr2) {
        List<Interval> intervalsIntersection = new ArrayList<Interval>();
        // TODO: Write your code here
        return intervalsIntersection.toArray(new Interval[intervalsIntersection.size()]);
    }

    public static void main(String[] args) {
        bruteFroce();
        //solution();
    }

    public static void bruteFroce() {
        Interval[] input1 = new Interval[]{new Interval(1, 3), new Interval(5, 6), new Interval(7, 9)};
        Interval[] input2 = new Interval[]{new Interval(2, 3), new Interval(5, 7)};
        Interval[] result = IntervalsIntersection.mergeBF(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input1 = new Interval[]{new Interval(1, 3), new Interval(5, 7), new Interval(9, 12)};
        input2 = new Interval[]{new Interval(5, 10)};
        result = IntervalsIntersection.mergeBF(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
    }

    public static void solution() {
        Interval[] input1 = new Interval[]{new Interval(1, 3), new Interval(5, 6), new Interval(7, 9)};
        Interval[] input2 = new Interval[]{new Interval(2, 3), new Interval(5, 7)};
        Interval[] result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input1 = new Interval[]{new Interval(1, 3), new Interval(5, 7), new Interval(9, 12)};
        input2 = new Interval[]{new Interval(5, 10)};
        result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
    }
}
