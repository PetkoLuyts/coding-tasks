package leetcode.arrays;

public class CheckIfTwoStringArraysAreEquivalent {
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String str1 = String.join("", word1);
        String str2 = String.join("", word2);

        if (str1.equals(str2)) return true;
        else return false;
    }

    public static void main(String[] args) {
        String[] word1 = new String[]{"ab", "c"};
        String[] word2 = new String[]{"a", "bc"};

        boolean arrayStringsAreEqual = arrayStringsAreEqual(word1, word2);

        System.out.println(arrayStringsAreEqual);
    }
}
