package leetcode.hashtable.easy;

public class CountTheNumberOfConsistentStrings {
    public static int countConsistentStrings(String allowed, String[] words) {
        int count = words.length;
        int[] store = new int[26];

        for (char c : allowed.toCharArray()) {
            store[c - 'a']++;
        }

        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (store[c - 'a'] <= 0) {
                    count--;
                    break;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String allowed = "ab";
        String[] words = new String[]{"ad","bd","aaab","baa","badab"};

        System.out.println(countConsistentStrings(allowed, words));
    }
}
