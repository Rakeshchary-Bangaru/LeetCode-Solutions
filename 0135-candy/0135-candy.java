class Solution {
    public int candy(int[] ratings) {
        int sum = 1;
        
      
        int n = ratings.length;
        int i= 1;
        while(i<n){
            if(ratings[i] == ratings[i-1]){
                sum = sum +1;
                i++;
                continue;
            }
            int peek = 1;
            while(i<n && ratings[i] > ratings[i-1]){
                peek = peek+1;
                sum = sum+peek;
                i++;
            }
              int down = 1;
            while(i<n && ratings[i] < ratings[i-1]){
                 sum = sum + down;
                down = down+1;
                i++;
            }

            if(down > peek){
                sum = sum + (down - peek);
            }
        }

        return sum;
    }
}