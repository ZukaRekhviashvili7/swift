package org.example;

import java.util.Arrays;
class problem3{
    public static void main(String[] args) {

        System.out.println(notContains(new int[]{-3, -2, -1, 0, 1, 3, 4, 5})); // Should print 2
        System.out.println(notContains(new int[]{-3, -2, 1, 2, 3, 4})); // Should print 5
        System.out.println(notContains(new int[]{-5, -4, -3, -2})); // Should print 1

    }


    public static int notContains(int[] array) {
        Arrays.sort(array);

        // If the array doesn't have any positive value, return 1.
        if(array[array.length - 1] <= 0) {
            return 1;
        }

        // If the first positive value in the array isn't 1, then 1 is the smallest missing positive integer.
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0 && array[i] != 1) {
                return 1;
            }
            if (array[i] == 1) {
                break;
            }
        }

        for (int i = 1; i < array.length; i++) {
            if (array[i] - array[i-1] > 1 && array[i-1] > 0) {
                return array[i-1] + 1;
            }
        }

        // If all the numbers are consecutive, return the next integer.
        return array[array.length - 1] + 1;
    }

}