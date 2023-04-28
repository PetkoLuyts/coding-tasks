package leetcode.arrays.easy;

import java.util.ArrayList;
import java.util.List;

public class CountItemsMatchingRule {
    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int matches = 0;

        for (List<String> item : items) {
            if (ruleKey.equals("type") && item.get(0).equals(ruleValue)) matches++;
            if (ruleKey.equals("color") && item.get(1).equals(ruleValue)) matches++;
            if (ruleKey.equals("name") && item.get(2).equals(ruleValue)) matches++;
        }

        return matches;
    }

    public static void main(String[] args) {
        List<List<String>> items = new ArrayList<>();
        List<String> innerList1 = new ArrayList<>();
        List<String> innerList2 = new ArrayList<>();
        List<String> innerList3 = new ArrayList<>();
        String ruleKey = "color";
        String ruleValue = "silver";

        innerList1.add("phone");
        innerList1.add("blue");
        innerList1.add("pixel");

        innerList2.add("computer");
        innerList2.add("silver");
        innerList2.add("lenovo");

        innerList3.add("phone");
        innerList3.add("gold");
        innerList3.add("iphone");

        items.add(innerList1);
        items.add(innerList2);
        items.add(innerList3);

        int matches = countMatches(items, ruleKey, ruleValue);

        System.out.println(matches);
    }
}
