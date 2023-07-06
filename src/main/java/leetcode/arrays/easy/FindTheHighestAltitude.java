package leetcode.arrays.easy;

public class FindTheHighestAltitude {
    public static int largestAltitude(int[] gain) {
        int max = 0;
        int currentValue = 0;

        for (int i = 0; i < gain.length; i++) {
            currentValue += gain[i];
            max = Math.max(max, currentValue);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] gain = new int[]{-4, -3, -2, -1, 4, 3, 2};

        System.out.println(largestAltitude(gain));
    }
}
