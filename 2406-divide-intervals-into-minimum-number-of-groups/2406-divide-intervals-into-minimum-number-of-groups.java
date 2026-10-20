class Solution {
    public int minGroups(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int i = 0;i<intervals.length;i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int maxCount = 0;
        int count = 0;
        int i =0;
        int j =0;
        while(i < intervals.length && j < intervals.length){
            if(start[i] <= end[j]){
                count++;
                i++;
            }
            else{
                count--;
                j++;
            }
            maxCount = Math.max(count , maxCount);
        }

        return maxCount;
    }
}