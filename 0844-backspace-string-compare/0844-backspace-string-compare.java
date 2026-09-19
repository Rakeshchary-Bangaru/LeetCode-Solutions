class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = build(s);
        Stack<Character> stack2 = build(t);

        if(stack1.size() != stack2.size()){
            return false;
        }

        while(!stack1.isEmpty()){
            if(stack1.pop() != stack2.pop()){
                return false;
            }
        }

        return true;

        
    }

    private Stack<Character> build(String s){
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '#'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else{
                stack.push(ch);
            }
        }

        return stack;
    }
}