

class Solution {
    public String minRemoveToMakeValid(String s) {
        int len = s.length();
        if(len == 1) {
            if(s.charAt(0) == '(' || s.charAt(0) == ')') return "";
            else return s;
        }
        
        Stack<Integer> stack = new Stack<>();
        Set<Integer> list = new HashSet<>();
        
        char[] ch = s.toCharArray();
        
        for(int i = 0; i < len; i++) {
            if(ch[i] == '(') stack.push(i);
            else if(ch[i] == ')') {
                if(stack.isEmpty()) list.add(i);
                else stack.pop();
            }
        }
        while(!stack.isEmpty()) list.add(stack.pop());
        StringBuffer res = new StringBuffer();
        for(int i = 0; i < len; i++) {
            if(ch[i] == '(' || ch[i] == ')') {
                if(!list.contains(i)) res.append(ch[i]);
            } else res.append(ch[i]);
        }
        
        return res.toString();
    }
}