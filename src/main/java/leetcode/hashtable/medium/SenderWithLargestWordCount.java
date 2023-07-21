package leetcode.hashtable.medium;

import java.util.*;

public class SenderWithLargestWordCount {
    public static String largestWordCount(String[] messages, String[] senders) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < senders.length; i++) {
            String[] currentMessage = messages[i].split(" ");

            if (!map.containsKey(senders[i])) {
                map.put(senders[i], currentMessage.length);
            } else {
                map.put(senders[i], map.get(senders[i]) + currentMessage.length);
            }
        }

        int max = map.values().stream().mapToInt(Integer::intValue).max().getAsInt();

        for (Map.Entry<String, Integer> set : map.entrySet()) {
            if (max == set.getValue()) {
                list.add(set.getKey());
            }
        }

        String[] names = list.toArray(String[]::new);
        Arrays.sort(names);

        return names[names.length - 1];
    }

    public static void main(String[] args) {
        String[] messages = new String[]{"tP x M VC h lmD","D X XF w V","sh m Pgl","pN pa","C SL m G Pn v","K z UL B W ee","Yf yo n V U Za f np","j J sk f qr e v t","L Q cJ c J Z jp E","Be a aO","nI c Gb k Y C QS N","Yi Bts","gp No g s VR","py A S sNf","ZS H Bi De dj dsh","ep MA KI Q Ou"};
        String[] senders = new String[]{"OXlq","IFGaW","XQPeWJRszU","Gb","HArIr","Gb","FnZd","FnZd","HArIr","OXlq","IFGaW","XQPeWJRszU","EMoUs","Gb","EMoUs","EMoUs"};
        System.out.println(largestWordCount(messages, senders));
    }
}


//["tP x M VC h lmD","D X XF w V","sh m Pgl","pN pa","C SL m G Pn v","K z UL B W ee","Yf yo n V U Za f np","j J sk f qr e v t","L Q cJ c J Z jp E","Be a aO","nI c Gb k Y C QS N","Yi Bts","gp No g s VR","py A S sNf","ZS H Bi De dj dsh","ep MA KI Q Ou"]
//        ["OXlq","IFGaW","XQPeWJRszU","Gb","HArIr","Gb","FnZd","FnZd","HArIr","OXlq","IFGaW","XQPeWJRszU","EMoUs","Gb","EMoUs","EMoUs"]