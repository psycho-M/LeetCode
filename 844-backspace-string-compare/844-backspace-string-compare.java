class Solution {
    public boolean backspaceCompare(String s, String t) {
        String s1 = getFinalString(s);
        String t1 = getFinalString(t);
        return s1.equals(t1);
        
    }
    
    String getFinalString(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '#') {
                if(!stack.isEmpty()) stack.removeLast();
            } else stack.add(c);
        }
        StringBuilder s1 = new StringBuilder();
        for(char c : stack) s1.append(c);
        return s1.toString();
    }
}