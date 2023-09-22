package org.example;

class problem4 {
    public static void main(String[] args) {

        String a = "1010";
        String b = "1011";
        System.out.println(addBinary(a, b));  // It should print "10101"
    }

    public static String addBinary(String a, String b) {
        String result = "";

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            result = (sum % 2) + result;
            carry = sum / 2;
        }

        if (carry != 0) {
            result = carry + result;
        }

        return result;
    }
}
