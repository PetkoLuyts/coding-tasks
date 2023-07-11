package leetcode.strings.easy;

public class FirstUniqueCharacterInAString {
    public static int firstUniqChar(String s) {
        int[] frequency = new int[26];

        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }

        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (frequency[i] == 1) {
                char ch = (char) (i + 'a');
                if (minIndex > s.indexOf(ch)) {
                    minIndex = s.indexOf(ch);
                }
            }
        }

        return minIndex == Integer.MAX_VALUE ? -1 : minIndex;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("aabb"));
    }
}
