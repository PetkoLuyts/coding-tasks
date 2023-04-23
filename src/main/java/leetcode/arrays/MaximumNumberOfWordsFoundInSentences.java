package leetcode.arrays;

public class MaximumNumberOfWordsFoundInSentences {
    public static int mostWordsFound(String[] sentences) {
        int mostWords = 0;

        for (int i = 0; i < sentences.length; i++) {
            String[] words = sentences[i].split(" ");
            int currentLength = words.length;

            if (currentLength > mostWords) mostWords = currentLength;
        }

        return mostWords;
    }

    public static void main(String[] args) {
        String[] sentences = new String[]{"alice and bob love leetcode", "i think so too",
                "this is great thanks very much"};

        int result = mostWordsFound(sentences);

        System.out.println(result);
    }
}
