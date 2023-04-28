package leetcode.arrays.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KidsWithGreatestNumberOfCandies {
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxNumberOfCandies = Arrays.stream(candies).max().getAsInt();
        List<Boolean> result = new ArrayList<>();

        for (int i = 0; i < candies.length; i++) {
            candies[i] += extraCandies;

            if (candies[i] >= maxNumberOfCandies) {
                result.add(true);
            } else result.add(false);
        }

        return result;

        // Second two - line solution
        // int max = Arrays.stream(candies).max().getAsInt();
        // return Arrays.stream(candies).mapToObj(candy -> candy + extraCandies >= max).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int[] candies = new int[]{2, 3, 5, 1, 3};
        int extraCandies = 3;

        List<Boolean> result = kidsWithCandies(candies, extraCandies);

        System.out.println(Arrays.toString(result.toArray()));
    }
}
