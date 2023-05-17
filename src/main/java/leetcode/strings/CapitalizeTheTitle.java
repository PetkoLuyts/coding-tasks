package leetcode.strings;

public class CapitalizeTheTitle {
    public static String capitalizeTitle(String title) {
        StringBuilder sb = new StringBuilder();
        String toLower = title.toLowerCase();

        String[] arr = toLower.split(" ");

        for (int i = 0; i < arr.length; i++) {
            String currentWord = arr[i];

            if (currentWord.length() > 2) {
                sb.append(currentWord.substring(0, 1).toUpperCase())
                        .append(currentWord.substring(1)).append(" ");
            } else {
                sb.append(currentWord).append(" ");
            }
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String title = "First leTTeR of EACH Word";

        System.out.println(capitalizeTitle(title));
    }
}
