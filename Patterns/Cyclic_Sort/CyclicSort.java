package Patterns.Cyclic_Sort;

/*
 * Problem: We are given an array containing n objects. Each object, when created, was assigned a
 * unique number from the range 1 to n based on their creation sequence. This means that the object
 * with sequence number 3 was created just before the object with sequence number 4.
 *
 * Write a function to sort the objects in-place on their creation sequence number in O(n)
 * and without using any extra space. For simplicity, let’s assume we are passed an integer array
 * containing only the sequence numbers, though each number is actually an object.
 *
 * Input: [3, 1, 5, 4, 2]
 * Output: [1, 2, 3, 4, 5]
 */
public class CyclicSort {
    public static void sort(int[] nums) {
        int index = 0;
        while (index < nums.length) {
            int curr = nums[index];
            if (curr - 1 == index) {
                index++;
            } else {
                int correctSpot = curr - 1;
                nums[index] = nums[correctSpot];
                nums[correctSpot] = curr;
            }
        }
    }
}
