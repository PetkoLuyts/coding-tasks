package blankfactor.exam.tasks;

import java.util.Arrays;

public class Task {
    public static String[] solution(String S, String T) {
        String[] answer = new String[4];
        StringBuilder thirdElement = new StringBuilder();
        StringBuilder fourthElement = new StringBuilder();

        String[] splitted = S.split(T);
        if (splitted.length == 1) {
            answer[0] = String.valueOf(splitted.length);
        } else {
            answer[0] = String.valueOf(splitted.length - 1);
        }
        answer[1] = splitted[0];

        Arrays.sort(splitted);
        if (splitted.length > 1) {
            for (int i = 1; i < splitted.length; i++) {
                thirdElement.append(splitted[i]).append(" ");
            }
        } else {
            for (int i = 0; i < splitted.length; i++) {
                thirdElement.append(splitted[i]).append(" ");
            }
        }

        for (int i = 0; i < S.length(); i+=2) {
            fourthElement.append(S.charAt(i));
        }

        answer[2] = thirdElement.toString().trim();
        answer[3] = fourthElement.toString();

        return answer;
    }

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(solution("abcdefSEPgabcwetSEPsdsSEPdsfgSEPfro", "SEP")));
        System.out.println(Arrays.toString(solution("abcdefgabcwetsdsdsfgfro", "SEP")));
    }
}
