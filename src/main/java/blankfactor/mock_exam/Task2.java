package blankfactor.mock_exam;

public class Task2 {
    public static int solution(String S) {
        int counter = 0;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'X') {
                i += 2;
                counter++;
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        String s = "XX.XXX..";

        System.out.println(solution(s));
    }
}
