class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
         int right = 0;
        for(int i =0;i<s.length && right < g.length;i++){
            if(s[i]>=g[right]){
                right++;
            }
        }

        return right;
    }
}