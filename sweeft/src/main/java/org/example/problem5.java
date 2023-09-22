package org.example;


class problem5 {
    public static void main(String[] args) {
        System.out.println(countVariants(1));  // Should print 1
        System.out.println(countVariants(2));  // Should print 2
        System.out.println(countVariants(3));  // Should print 3 (1+1+1, 1+2, 2+1)
        System.out.println(countVariants(4));  // Should print 5
    }

    public static int countVariants(int stearsCount) {
        if (stearsCount <= 1) {
            return 1;
        }

        int[] ways = new int[stearsCount + 1];
        ways[0] = 1;
        ways[1] = 1;

        for (int i = 2; i <= stearsCount; i++) {
            ways[i] = ways[i - 1] + ways[i - 2];
        }

        return ways[stearsCount];
    }

}