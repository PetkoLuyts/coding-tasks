package leetcode.strings;

public class TruncateSentence {
    public static String truncateSentence(String s, int k) {
        StringBuilder sb = new StringBuilder();
        String[] splitted = s.split(" ");

        for (int i = 0; i < k; i++) {
            sb.append(splitted[i]).append(" ");
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String s = "chopper is not a tanuki";
        int k = 5;

        System.out.println(truncateSentence(s, k));
    }
}
