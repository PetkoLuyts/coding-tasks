package leetcode.strings.easy;

public class DetectCapital {
    public static boolean detectCapitalUse(String word) {
        if(word.length() == 0 || word.length() == 1) return true;

        if (Character.isUpperCase(word.charAt(0))) {
            boolean isFirstChar = Character.isUpperCase(word.charAt(1));

            for (int i = 2; i < word.length(); i++) {
                boolean currentCharState = Character.isUpperCase(word.charAt(i));

                if (isFirstChar != currentCharState) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("USA"));
    }
}
