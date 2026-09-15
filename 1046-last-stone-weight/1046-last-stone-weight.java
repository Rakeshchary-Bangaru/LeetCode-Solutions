class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>( Collections.reverseOrder());

        for(int i : stones){
            heap.offer(i);
        }

        while(heap.size() > 1 ){
            
            int largest = heap.poll();
            int secondLargest = heap.poll();

            int difference = largest - secondLargest;

            if (difference > 0) {
                heap.offer(difference);
            }
            

        }

       return heap.isEmpty() ? 0 : heap.peek();
    }
}