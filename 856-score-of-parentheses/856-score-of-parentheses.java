class Solution {
    /*
        We use Stack and depth of parentheses concept here.
        
        Here we have to score the valid brackets string based on the depth of
        the parentheses.
        
        First we add opening parentheses to the stack.
        When we encounter a closing patentheses, we calculate the depth of this
        particular set of opening and closing parentheses. The depth will be the
        (length of the stack - 1). The depth will be the power of 2. 
        We add this to the score and pop elements from the stack until we encounter
        an opening parentheses.
        We keep repeating this util we reach the end of string.
    */
    
    public int scoreOfParentheses(String s) {
        int len = s.length(), score = 0;
        if(len == 2) return 1;
        Stack<Character> stack = new Stack<>();        
        char c;
        int i = 0;
        while(i < len) {
            c = s.charAt(i);
            if(c == '(') {
                stack.push(c);
                i++;
            }
            else {
                score += Math.pow(2, stack.size() - 1);
                while(i < len && s.charAt(i) == ')') {
                    stack.pop();
                    i++;
                }
            }
        }
        return score;
    }
}