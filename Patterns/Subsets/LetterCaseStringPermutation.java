package Patterns.Subsets;

import java.util.*;

public class LetterCaseStringPermutation {
    public static List<String> findLetterCaseStringPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        permutations.add(str);
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                int size = permutations.size();
                for (int j = 0; j < size; j++) {
                    char[] chs = permutations.get(j).toCharArray();
                    if (Character.isUpperCase(chs[i])) {
                        chs[i] = Character.toLowerCase(chs[i]);
                    } else {
                        chs[i] = Character.toUpperCase(chs[i]);
                    }
                    permutations.add(String.valueOf(chs));
                }
            }
        }
        return permutations;
    }

    public static void main(String[] args) {
        List<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ad52");
        System.out.println(" String permutations are: " + result);

        result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ab7c");
        System.out.println(" String permutations are: " + result);
    }
}
