class Solution {
    public int sortPermutation(int[] nums) {
        int ans = -1;
        boolean misplaced = false;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                if (!misplaced) {
                    ans = nums[i];
                    misplaced = true;
                } else {
                    ans &= nums[i];
                }
            }
        }

        return misplaced ? ans : 0;
    }
}