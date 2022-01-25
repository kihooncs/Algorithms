package Patterns.Cyclic_Sort;

import java.util.*;

public class AllMissingNumbers {
    /*
     * We are given an unsorted array containing numbers taken from the range 1 to ‘n’. The array can have duplicates,
     * which means some numbers will be missing. Find all those missing numbers.
     *
     * Example 1:
     * Input: [2, 3, 1, 8, 2, 3, 5, 1]
     * Output: 4, 6, 7
     * Explanation: The array should have all numbers from 1 to 8, due to duplicates 4, 6, and 7 are missing.
     *
     * Example 2:
     * Input: [2, 4, 1, 2]
     * Output: 3
     */
    public static List<Integer> findNumbersBF(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();
        int index = 0;
        while (index < nums.length) {
            int curr = nums[index];
            if (curr - 1 != index) {
                if (nums[curr - 1] == curr) {
                    missingNumbers.add(index + 1);
                    index++;
                } else {
                    swap(nums, curr - 1, index);
                }
            } else {
                index++;
            }
        }
        return missingNumbers;
    }

    public static List<Integer> findNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
            else
                i++;
        }

        List<Integer> missingNumbers = new ArrayList<>();
        for (i = 0; i < nums.length; i++)
            if (nums[i] != i + 1)
                missingNumbers.add(i + 1);

        return missingNumbers;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        List<Integer> missing = AllMissingNumbers.findNumbers(new int[] { 2, 3, 1, 8, 2, 3, 5, 1 });
        System.out.println("Missing numbers: " + missing);

        missing = AllMissingNumbers.findNumbers(new int[] { 2, 4, 1, 2 });
        System.out.println("Missing numbers: " + missing);

        missing = AllMissingNumbers.findNumbers(new int[] { 2, 3, 2, 1 });
        System.out.println("Missing numbers: " + missing);
    }
}
