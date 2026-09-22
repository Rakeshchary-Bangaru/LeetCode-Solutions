class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int i =0;
        int j = height.length - 1;
        while(i<=j){
             int h = Math.min(height[i], height[j]);
            int width = j - i;

            int currentArea = h * width;
            maxArea = Math.max(maxArea, currentArea);

            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxArea;
    }
}