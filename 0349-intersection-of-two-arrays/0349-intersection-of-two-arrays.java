class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer,Boolean> set = new HashMap<>();
        int length1 = nums1.length;
        int length2 = nums2.length;
        int length = (length1<length2) ? length1 : length2;
        int[] result = new int[length];
        for(int i : nums1){
            set.put(i,true);
        }
        int index = 0;
        for(int i : nums2){
            if(set.get(i)!=null){
                result[index] = i;
                index++;
                set.remove(i);
            }
        }

        return Arrays.copyOf(result,index);
    }
}