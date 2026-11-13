class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {

        int n = nums.length;

        Deque<Integer> deque = new ArrayDeque<>();

        long cost = 0;
        long ans = 0;

        int right = n - 1;

        for (int left = n - 1; left >= 0; left--) {

          
            while (!deque.isEmpty()
                    && nums[deque.peekFirst()] < nums[left]) {

                int index = deque.pollFirst();

                int nextIndex;

                if (deque.isEmpty()) {
                    nextIndex = right + 1;
                } else {
                    nextIndex = deque.peekFirst();
                }

                cost += (long)
                        (nums[left] - nums[index])
                        * (nextIndex - index);
            }

            deque.addFirst(left);

           
            while (cost > k) {

                int maxIndex = deque.peekLast();

                cost -= nums[maxIndex] - nums[right];

                if (maxIndex == right) {
                    deque.pollLast();
                }

                right--;
            }

            ans += right - left + 1;
        }

        return ans;
    }
}