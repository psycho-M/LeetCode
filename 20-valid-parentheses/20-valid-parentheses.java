class Solution {
    public boolean isValid(String s) {
        
        char[] ch = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        
        HashMap<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
    
        for(int i = 0; i < ch.length; i++) {
            if(isOpening(ch[i])) stack.push(ch[i]);
            else if(stack.isEmpty() || stack.pop() != map.get(ch[i]))
                return false;
        }
        
        if(stack.isEmpty()) return true;
        else return false;
    }
    
    private boolean isOpening(char c) {
        return c == '(' || c == '{' || c == '[';
    }
    
    // private boolean isClosing(char c) {
    //     return c == ')' || c == '}' || c == ']';
    // }
}