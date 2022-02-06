package Patterns.Subsets;

import java.util.*;

public class Permutations {
    public static List<List<Integer>> findPermutationsBF(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> permutations = new LinkedList<>();
        permutations.add(new ArrayList<>());
        for (int curentNumber : nums) {
            int size = permutations.size();
            for (int i = 0; i < size; i++) {
                List<Integer> oldPermutation = permutations.remove();
                for (int j = 0; j <= oldPermutation.size(); j++) {
                    List<Integer> newPermutation = new ArrayList<>(oldPermutation);
                    newPermutation.add(j, curentNumber);
                    if (newPermutation.size() == nums.length) {
                        result.add(newPermutation);
                    } else {
                        permutations.add(newPermutation);
                    }
                }
            }
        }
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
