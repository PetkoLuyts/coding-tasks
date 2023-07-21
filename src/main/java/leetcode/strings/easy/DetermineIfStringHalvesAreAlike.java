package leetcode.strings.easy;

public class DetermineIfStringHalvesAreAlike {
    public static boolean halvesAreAlike(String s) {
        String vowels = "aeiouAEIOU";
        int ans = 0;

        for (int i = 0; i < s.length() / 2; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                ans++;
            }
        }

        for (int i = s.length() / 2; i < s.length(); i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                ans--;
            }
        }

        return ans == 0;
    }

    public static void main(String[] args) {
        System.out.println(halvesAreAlike("textbok"));
    }
}
