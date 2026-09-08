class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0) return 0;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<=heights.length;i++){
            int h = (i==heights.length) ? 0 : heights[i];
            while(!stack.isEmpty() && h < heights[stack.peek()]){
                int height = heights[stack.pop()];
                int width = (stack.isEmpty())? i :i-stack.peek()-1;
                int area = height * width;
                maxArea = Math.max(area,maxArea);
            }
            stack.push(i);
        }

        return maxArea;
    }
}