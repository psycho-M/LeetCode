class Solution {
    public int maxDepth(String s) {
        int len = s.length();
        if(len == 0) return 0;
        Stack<Character> stack = new Stack<>();
        int depth = 0, maxD = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') stack.push(c);
            else if(c == ')') {
                maxD = Math.max(maxD, stack.size());
                stack.pop();
            }
        }
        return maxD;
    }
}