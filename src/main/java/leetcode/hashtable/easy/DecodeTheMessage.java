package leetcode.hashtable.easy;

import java.util.HashMap;

public class DecodeTheMessage {
    public static String decodeMessage(String key, String message) {
        StringBuilder result = new StringBuilder();
        HashMap<Character, Character> letters = new HashMap<>();

        key = key.replaceAll(" ", "");

        char initialChar = 'a';

        for (int i = 0; i < key.length(); i++) {
            if (!letters.containsKey(key.charAt(i))) {
                letters.put(key.charAt(i), initialChar++);
            }
        }

        for (int i = 0; i < message.length(); i++) {
            if (letters.containsKey(message.charAt(i))) {
                result.append(letters.get(message.charAt(i)));
            } else {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";

        System.out.println(decodeMessage(key, message));
    }
}
