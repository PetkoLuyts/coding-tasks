package leetcode.strings;

public class DefangingIPAddress {
    public static String defangIPaddr(String address) {
        String result = address.replace(".", "[.]");

        return result;
    }

    public static void main(String[] args) {
        String address = "255.100.50.0";

        System.out.println(defangIPaddr(address));
    }
}
