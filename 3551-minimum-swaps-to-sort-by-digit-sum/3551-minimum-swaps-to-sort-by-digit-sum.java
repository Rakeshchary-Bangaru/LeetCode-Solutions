class Solution {

    public int minSwaps(int[] nums) {

        int n = nums.length;

        Integer[] target = new Integer[n];

        for (int i = 0; i < n; i++) {
            target[i] = nums[i];
        }

        
        Arrays.sort(target, (a, b) -> {

            int sumA = digitSum(a);
            int sumB = digitSum(b);

            if (sumA != sumB) {
                return Integer.compare(sumA, sumB);
            }

            return Integer.compare(a, b);
        });

        
        HashMap<Integer, Integer> position = new HashMap<>();

        for (int i = 0; i < n; i++) {
            position.put(nums[i], i);
        }

        int swaps = 0;

        for (int i = 0; i < n; i++) {

          
            if (nums[i] == target[i]) {
                continue;
            }

           
            int correctIndex = position.get(target[i]);

            int currentValue = nums[i];
            int correctValue = nums[correctIndex];

      
            nums[i] = correctValue;
            nums[correctIndex] = currentValue;

       
            position.put(correctValue, i);
            position.put(currentValue, correctIndex);

            swaps++;
        }

        return swaps;
    }

    private int digitSum(int num) {

        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}