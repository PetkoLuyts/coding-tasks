package leetcode.strings.easy;

public class FindMaximumNumberOfStringPairs {
    public static int maximumNumberOfStringPairs(String[] words) {
        int counter = 0;

        for (int i = 0; i < words.length; i++) {
            StringBuilder stringBuilder = new StringBuilder(words[i]);
            stringBuilder.reverse();
            String word = stringBuilder.toString();;

            for (int j = i + 1; j < words.length; j++) {
                if (word.equals(words[j])) counter++;
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        System.out.println(maximumNumberOfStringPairs(new String[]{"cd","ac","dc","ca","zz"}));
    }
}
