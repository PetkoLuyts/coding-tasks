package blankfactor.hashtable;

import java.util.HashMap;
import java.util.Map;

public class HashMapOccurrences {
    public static void main(String[] args) {
        String[] names = new String[]{"Alice", "Bob", "Alice"};
        HashMap<String, Integer> counts = new HashMap<>();

        for (String name : names) {
            if (!counts.containsKey(name)) {
                counts.put(name, 1);
            } else {
                counts.put(name, counts.get(name) + 1);
            }
        }

        for (Map.Entry<String, Integer> set : counts.entrySet()) {
            System.out.println(set.getKey() + " = "
                    + set.getValue());
        }
    }
}