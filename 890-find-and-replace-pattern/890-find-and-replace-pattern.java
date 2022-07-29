class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        
        for(String s : words) {
            if(isPermutation(s, pattern)) res.add(s);
        }
        
        return res;
    }
    
    public boolean isPermutation(String s, String pattern) {
        if(s.length() != pattern.length()) return false;
        Map<Character, Character> patternMap = new HashMap<>();
        Set<Character> visited = new HashSet<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i), pc = pattern.charAt(i);
            if(patternMap.containsKey(pc)) {
                if(patternMap.get(pc) != c) return false;
            } else {
                if(visited.contains(c)) return false;
                else {
                    visited.add(c);
                    patternMap.put(pc, c);
                }
            }
        }
        
        return true;
    }
}