class Solution {
    public String simplifyPath(String p) {
        return pathSimplifySimplified(p);
        // return p;
    }
    
    public String pathSimplifySimplified(String p) {
        Stack<String> stack = new Stack<>();
        Set<String> set = new HashSet();
        set.add(".");
        set.add("..");
        set.add("");
        String[] split = p.split("/");
        for(String s : split) {
            if(!stack.isEmpty() && s.equals("..")) stack.pop();
            else if(!set.contains(s)) stack.push(s);
        }
        
        if(stack.isEmpty()) return "/";
        
        StringBuffer res = new StringBuffer();
        for(String s : stack) {
            res.append("/");
            res.append(s);
        }
        
        return res.toString();
    }
    
    public String pathSimplify(String p) {
        if(p.length() == 1) return p;
        Stack<String> stack = new Stack<>();
        boolean isSlash = false, isDot = false, isOther = false;
        int len = p.length();
        System.out.println(len);
        int i = 0, r = 0;
        while(i < len) {
            char c = p.charAt(i);
            if(c == '/') {
                r = i + 1;
                while(r < len && p.charAt(r) == '/') {
                    r++;
                }
                
                if(r == len) {
                    if(stack.isEmpty()) stack.push("/");
                    break;
                }
                stack.push("/");
                i = r;
            } else if(c == '.') {
                r = i + 1;
                if(r == len) {
                    if(stack.size() != 1) stack.pop();
                    break;
                }
                if(r < len) {
                    if(p.charAt(r) == '/') {
                        if(stack.size() > 0)stack.pop();
                        i++;
                    } else if(p.charAt(r) == '.') {
                        r = r + 1;
                        if(r < len && p.charAt(r) != '/') {
                            r = r + 1;
                            while(r < len && p.charAt(r) == '.') {
                                r++;
                            }
                            stack.push(p.substring(i, r));
                            i = r;
                        } else {
                            for(int j = 0; j < 3 && stack.size() > 1; j++) stack.pop();
                            i = r + 1;
                        }
                    } else {
                        while(r < len && p.charAt(r) != '/')
                            r++;
                        stack.push(p.substring(i, r));
                        i = r;
                    }
                } 
                
            } else {
                r = r + 1;
                while(r < len && p.charAt(r) != '/') {
                    r++;
                }
                
                stack.push(p.substring(i, r));
                i = r;
            }
            System.out.println(stack + " i: " + i + " r: " + r);
        }
        StringBuffer res = new StringBuffer();
        for(String s : stack) {
            res.append(s);
        }
        return res.toString();
    }
}