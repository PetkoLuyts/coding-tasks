package leetcode.strings.easy;

public class StudentAttendanceRecord {
    public static boolean checkRecord(String s) {
        int absenceCount = 0;
        int lateCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (currentChar == 'A') {
                absenceCount++;
                if (absenceCount >= 2) {
                    return false;
                }
            } else if (currentChar == 'L') {
                for (int j = i; j < s.length(); j++) {
                    if (s.charAt(j) == 'L') {
                        lateCount++;
                        i = j;

                        if (lateCount >= 3) return false;
                    } else {
                        lateCount = 0;
                        break;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkRecord("ALLAPPL"));
    }
}
