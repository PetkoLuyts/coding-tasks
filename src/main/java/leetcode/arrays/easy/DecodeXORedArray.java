package leetcode.arrays.easy;

import java.util.Arrays;

public class DecodeXORedArray {
    public static int[] decode(int[] encoded, int first) {
        int[] decoded = new int[encoded.length + 1];
        decoded[0] = first;

        for (int i = 0; i < encoded.length; i++) {
            decoded[i + 1] = decoded[i] ^ encoded[i];
        }

        return decoded;
    }

    public static void main(String[] args) {
        int[] encoded = new int[]{6, 2, 7, 3};
        int first = 4;

        int[] decoded = decode(encoded, first);

        System.out.println(Arrays.toString(decoded));
    }
}
