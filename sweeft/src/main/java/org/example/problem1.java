package org.example;

class problem1{
    public static void main(String[] args) {

        int[] nums = {4, 1, 2, 1, 2,3,12,12,3,3,33,33 };
        System.out.println(singleNumber(nums));  // It should print 4



    }

    public static int singleNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean isDuplicate = false;

            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] == nums[j]) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                return nums[i];
            }
        }
        throw new IllegalArgumentException("No single number found!");
    }


}