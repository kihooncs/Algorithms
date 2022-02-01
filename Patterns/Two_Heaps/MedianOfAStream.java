package Patterns.Two_Heaps;

import java.util.*;

public class MedianOfAStream {
    public void insertNumBF(int num) {
        // TODO: Write your code here
    }

    public double findMedianBF() {
        // TODO: Write your code here
        return -1;
    }

    public void insertNum(int num) {
        // TODO: Write your code here
    }

    public double findMedian() {
        // TODO: Write your code here
        return -1;
    }

    public static void main(String[] args) {
        bruteForce();
        //solution();
    }

    public static void bruteForce() {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNumBF(3);
        medianOfAStream.insertNumBF(1);
        System.out.println("The median is: " + medianOfAStream.findMedianBF());
        medianOfAStream.insertNumBF(5);
        System.out.println("The median is: " + medianOfAStream.findMedianBF());
        medianOfAStream.insertNumBF(4);
        System.out.println("The median is: " + medianOfAStream.findMedianBF());
    }

    public static void solution() {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        System.out.println("The median is: " + medianOfAStream.findMedian());
    }
}
