class Solution {
    public boolean checkString(String s) {
        boolean flag = true;
        for(int i =1;i<s.length();i++){
            char curr = s.charAt(i);
            char prev = s.charAt(i-1);

            if(prev == 'b' && curr == 'a'){
                flag = false;
            }


        }

        return flag;
    }
}