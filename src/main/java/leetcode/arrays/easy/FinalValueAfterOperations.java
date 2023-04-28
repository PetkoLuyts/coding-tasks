package leetcode.arrays.easy;

public class FinalValueAfterOperations {
    public static int finalValueAfterOperations(String[] operations) {
        int x = 0;

        for (String operation : operations) {
            if (operation.contains("+")) {
                x++;
            } else x--;
        }

        return x;
    }

    public static void main(String[] args) {
        String[] operations = new String[]{"X++","++X","--X","X--"};

        int result = finalValueAfterOperations(operations);

        System.out.println(result);
    }
}
