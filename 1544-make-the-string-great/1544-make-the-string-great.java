class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!stack.isEmpty() && ((char)(ch + 32) == stack.peek() || (char)(ch - 32) == stack.peek())){
                stack.pop();
            }
            else{
                stack.push(ch);
            }
        }

        StringBuffer newString = new StringBuffer();
        while(!stack.isEmpty()){
            newString.append(stack.pop());
        }

        return newString.reverse().toString();
    }
}