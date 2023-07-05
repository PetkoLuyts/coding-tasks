package leetcode.strings.easy;

public class NumberOfSeniorCitizens {
    public static int countSeniors(String[] details) {
        int result = 0;

        for(String detail : details) {
            int age = Integer.parseInt(detail.substring(11, 13));

            if (age > 60) result++;
        }

        return result;
    }

    public static void main(String[] args) {
        String[] details = new String[] {"7868190130M7522", "5303914400F9211","9273338290F4010"};

        System.out.println(countSeniors(details));
    }
}
