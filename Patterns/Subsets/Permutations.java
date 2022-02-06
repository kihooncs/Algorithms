package Patterns.Subsets;

import java.util.*;

public class Permutations {
    public static List<List<Integer>> findPermutationsBF(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // TODO: Write your code here
        return result;
    }

    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // TODO: Write your code here
        return result;
    }

    public static void main(String[] args) {
        bruteForce();
        //solution();
    }

    public static void bruteForce() {
        List<List<Integer>> result = Permutations.findPermutationsBF(new int[] { 1, 3, 5 });
        System.out.print("Here are all the permutations: " + result);
    }

    public static void solution() {
        List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
        System.out.print("Here are all the permutations: " + result);
    }
}
