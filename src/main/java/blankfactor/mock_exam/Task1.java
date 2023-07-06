package blankfactor.mock_exam;

public class Task1 {
    public static boolean solution(String S) {
        int indexB = 0;
        boolean hasAAfterB = false;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'b') {
                indexB = i;
            }

            if (S.charAt(i) == 'a' && i > indexB) {
                hasAAfterB = true;
                break;
            }
        }

        return hasAAfterB;
    }

    public static void main(String[] args) {
        System.out.println(solution("abbb"));
    }
}
