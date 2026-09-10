class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dequeue = new ArrayDeque<>();
        int[] result = new int[n-k+1];

        for(int i=0;i<k;i++){
            while(!dequeue.isEmpty() && nums[dequeue.peekLast()]<= nums[i]){
                dequeue.pollLast();
            }
            dequeue.offerLast(i);
        }

        result[0] = nums[dequeue.peekFirst()];

        for(int i= k;i<n;i++){
            if(dequeue.peekFirst() <= i-k){
                dequeue.pollFirst();
            }

            while(!dequeue.isEmpty() && nums[dequeue.peekLast()] <= nums[i]){
                dequeue.pollLast();
            }
            dequeue.offerLast(i);

            result[i-k+1] = nums[dequeue.peekFirst()];
        }

        return result;
    }
}