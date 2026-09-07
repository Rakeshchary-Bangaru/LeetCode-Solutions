class Solution {
    public int trap(int[] height) {
       if (height == null || height.length == 0) {
            return 0;
        }

        int n = height.length;

        int l = 0;
        int r = n - 1;

        int leftMax = height[l];
        int rightMax = height[r];

        int total = 0;

        while (l < r) {

            if (leftMax <= rightMax) {

                l++;

                if (height[l] >= leftMax) {
                    leftMax = height[l];
                } else {
                    total += leftMax - height[l];
                }

            } else {

                r--;

                if (height[r] >= rightMax) {
                    rightMax = height[r];
                } else {
                    total += rightMax - height[r];
                }
            }
        }

        return total;
    }
}