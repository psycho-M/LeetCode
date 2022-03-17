class Solution {
    public int scoreOfParentheses(String s) {
        int len = s.length(), score = 0;
        if(len == 2) return 1;
        Stack<Character> stack = new Stack<>();        
        char c;
        int i = 0;
        while(i < len) {
            // System.out.println("i: " + i);
            c = s.charAt(i);
            if(c == '(') {
                stack.push(c);
                i++;
            }
            else {
                score += Math.pow(2, stack.size() - 1);
                while(i < len && s.charAt(i) == ')') {
                    // System.out.println("i: " + i);
                    stack.pop();
                    i++;
                }
            }
        }
        return score;
    }
}