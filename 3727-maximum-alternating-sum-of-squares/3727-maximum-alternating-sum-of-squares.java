class Solution {
    public long maxAlternatingSum(int[] nums) {
        long[] squares = new long[nums.length];

        for (int i = 0; i < nums.length; i++) {
            squares[i] = 1L * nums[i] * nums[i];
        }

        Arrays.sort(squares);

        long score = 0;

        int positiveCount = (nums.length + 1) / 2;
        int negativeCount = nums.length / 2;

        for (int i = 0; i < negativeCount; i++) {
            score -= squares[i];
        }

        for (int i = negativeCount; i < nums.length; i++) {
            score += squares[i];
        }

        return score;
    }
    
}