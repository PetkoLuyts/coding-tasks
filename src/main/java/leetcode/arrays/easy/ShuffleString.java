package leetcode.arrays.easy;

public class ShuffleString {
    public static String restoreString(String s, int[] indices) {
        char[] restoredCharArr = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            int index = indices[i];
            char ch = s.charAt(i);
            restoredCharArr[index] = ch;
        }

        String restored = String.valueOf(restoredCharArr);
        return restored;
    }

    public static void main(String[] args) {
        String s = "codeleet";
        int[] indices = new int[]{4, 5, 6, 7, 0, 2, 1, 3};

        String restoredString = restoreString(s, indices);

        System.out.println(restoredString);
    }
}
