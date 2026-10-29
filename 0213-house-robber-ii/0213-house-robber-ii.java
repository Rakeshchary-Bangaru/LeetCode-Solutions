class Solution {

    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int[] temp1 = new int[n - 1];
        int[] temp2 = new int[n - 1];

        int j = 0;
        int k = 0;

        for (int i = 0; i < n; i++) {

            
            if (i != 0) {
                temp1[j++] = nums[i];
            }

         
            if (i != n - 1) {
                temp2[k++] = nums[i];
            }
        }

        return Math.max(
                robLinear(temp1),
                robLinear(temp2)
        );
    }

    private int robLinear(int[] nums) {

        int prev = nums[0];
        int prev2 = 0;

        for (int i = 1; i < nums.length; i++) {

            int take = nums[i] + prev2;

            int notTake = prev;

            int curr = Math.max(take, notTake);

            prev2 = prev;
            prev = curr;
        }

        return prev;
    }
}