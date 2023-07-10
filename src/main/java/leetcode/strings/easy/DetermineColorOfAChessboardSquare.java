package leetcode.strings.easy;

public class DetermineColorOfAChessboardSquare {
    public static boolean squareIsWhite(String coordinates) {
        int ascii = coordinates.charAt(0);
        int number = Integer.parseInt(String.valueOf(coordinates.charAt(1)));

        if (ascii % 2 != 0) {
            return number % 2 == 0;
        } else {
            return number % 2 != 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(squareIsWhite("b1"));
    }
}
