class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = 0;
        int m = nums1.length;
        int n = nums2.length;

        total = m+n;

        int i = 0;
        int j = 0;

        int prev = 0;
        int curr = 0;

        for(int count = 0;count <= total/2;count++){
            prev = curr;

            if(i<m && j<n){
                if(nums1[i] < nums2[j]){
                    curr = nums1[i++];
                }
                else{
                    curr = nums2[j++];
                }
            }

            else if ( i< m){
                curr = nums1[i++];
            }

            else if( j < n){
                curr = nums2[j++];
            }
        }

        if(total %2 !=0){
            return curr;
        }
        else{
            return (prev + curr)/2.0 ;
        }
    }
}