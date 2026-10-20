class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int[] target = nums.clone();
        Arrays.sort(target);
        List<Integer> divisors = new ArrayList<>();
        for(int i =1;i<=n;i++){
            if(n % i == 0){
                divisors.add(i);
            }
        }
        int answer = 0;
        for(int k : divisors){
            if(isSortable(nums,target,k)){
                answer += k;
            }
        }

        return answer;
    }

        private boolean isSortable(int[] nums, int[] target, int k) {

        for (int start = 0; start < nums.length; start += k) {

            HashMap<Integer, Integer> map = new HashMap<>();

            
            for (int i = start; i < start + k; i++) {

                map.put(
                    nums[i],
                    map.getOrDefault(nums[i], 0) + 1
                );

                map.put(
                    target[i],
                    map.getOrDefault(target[i], 0) - 1
                );
            }

            for (int value : map.values()) {
                if (value != 0) {
                    return false;
                }
            }

            
            int drops = 0;

            for (int i = 0; i < k; i++) {

                int current = nums[start + i];

                int next =
                    nums[start + ((i + 1) % k)];

                if (current > next) {
                    drops++;
                }

                if (drops > 1) {
                    return false;
                }
            }
        }

        return true;
    }
}