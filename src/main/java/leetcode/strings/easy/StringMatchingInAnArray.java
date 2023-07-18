package leetcode.strings.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringMatchingInAnArray {
    public static List<String> stringMatching(String[] words) {
        String str = String.join(" ", words);
        List<String> res = new ArrayList<>();

        for(int i = 0; i < words.length; i++){
            if(str.indexOf(words[i]) != str.lastIndexOf(words[i])){
                res.add(words[i]);
            }
        }

        return res;

//        Set<String> answer = new HashSet<>();
//
//        for (int i = 0; i < words.length; i++) {
//            for (int j = 0; j < words.length; j++) {
//                if (i != j && words[i].contains(words[j])) {
//                    answer.add(words[j]);
//                }
//            }
//        }
//
//        return answer.stream().toList();
    }

    public static void main(String[] args) {
        System.out.println(stringMatching(new String[]{"mass","as","hero","superhero"}));
    }
}
