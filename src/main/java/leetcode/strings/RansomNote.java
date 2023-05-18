package leetcode.strings;

public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] alphabet = new int[26];

        for (char c : magazine.toCharArray()) {
            alphabet[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (alphabet[c - 'a'] == 0) return false;
            alphabet[c - 'a']--;
        }

        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";

        System.out.println(canConstruct(ransomNote, magazine));
    }
}
