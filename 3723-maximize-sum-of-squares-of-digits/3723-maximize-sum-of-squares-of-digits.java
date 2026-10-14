class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum > 9 * num){
            return "";
        }

        StringBuilder string = new StringBuilder();

        int nines = sum/9;
        int remainder = sum%9;

        for(int i =0;i<nines;i++){
            string.append("9");
        }
        if(remainder > 0){
            string.append(remainder);
        }

        while(string.length()<num){
            string.append("0");
        }

        return string.toString();
    }
}