package org.example;


class problem2{
    public static void main(String[] args) {
        System.out.println(minSplit(98)); // Should print 7 (1 x 50, 2 x 20, 1 x 5, 3 x 1)
        System.out.println(minSplit(123)); // Should print 6
    }
    public static int minSplit(int amount) {
        int[] coins = {50, 20, 10, 5, 1}; // Coin denominations must be descending order
        int count = 0;

        for (int coin : coins) {
            while (amount >= coin) {
                amount -= coin;
                count++;
            }
        }

        return count;
    }

}