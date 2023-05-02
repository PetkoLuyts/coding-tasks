package leetcode.hashtable.easy;

import java.util.HashSet;
import java.util.Set;

public class CheckIfSentenceIsPangram {
    public static boolean checkIfPangram(String sentence) {
        Set<Character> letters = new HashSet<>();

        for (int i = 0; i < sentence.length(); i++) {
            letters.add(sentence.charAt(i));
        }

        return letters.size() == 26;
    }

    public static void main(String[] args) {
        String sentence = "thequickbrownfoxjumpsoverthelazydog";

        System.out.println(checkIfPangram(sentence));
    }
}
