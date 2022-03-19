package Patterns;

public class BlackSpace {
    public static void main(String[] args) {
        String str = "kihoon";
        char[] ca = new char[26];
        for (char c : str.toCharArray()) ca[c - 'a']++;
        System.out.println(String.valueOf(ca));
    }
}
