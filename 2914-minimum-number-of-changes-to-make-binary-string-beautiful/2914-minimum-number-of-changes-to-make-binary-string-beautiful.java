class Solution {
    public int minChanges(String s) {
       int count = 0;

        for(int i =1;i<s.length();i+=2){
            char curr = s.charAt(i);
            char prev = s.charAt(i-1);
            if(curr != prev){
                count++;
            }
        }

        return count;
    }
}