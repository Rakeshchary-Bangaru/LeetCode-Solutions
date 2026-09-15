class Solution {
    public int[] finalPrices(int[] prices) {
        int[] result = prices.clone();
        Stack<Integer> stack = new Stack<>();

        for(int i =0;i<prices.length;i++){
            int current = prices[i];
            while(!stack.isEmpty() && current <= prices[stack.peek()]){
                int index = stack.pop();
                result[index] = prices[index] - current;
            }

            stack.push(i);
        }

        return result;
    }
}