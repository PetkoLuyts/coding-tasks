package leetcode.hashtable.easy;

import java.util.*;

public class DestinationCity {
    public static String destCity(List<List<String>> paths) {
        Map<String, String> cityMap = new HashMap<>();

        for (List<String> path : paths) {
            cityMap.put(path.get(0), path.get(1));
        }

        String destinationCity = paths.get(0).get(1);

        while (cityMap.get(destinationCity) != null) {
            destinationCity = cityMap.get(destinationCity);
        }

        return destinationCity;
    }

    public static void main(String[] args) {
        List<List<String>> paths = new ArrayList<>();

        List<String> cities1 = new ArrayList<>();
        List<String> cities2 = new ArrayList<>();
        List<String> cities3 = new ArrayList<>();

//        cities1.add("London");
//        cities1.add("New York");
//        cities2.add("New York");
//        cities2.add("Lima");
//        cities3.add("Lima");
//        cities3.add("Sao Paulo");

        cities1.add("B");
        cities1.add("C");
        cities2.add("D");
        cities2.add("B");
        cities3.add("C");
        cities3.add("A");

        paths.add(cities1);
        paths.add(cities2);
        paths.add(cities3);

        System.out.println(destCity(paths));
    }
}
