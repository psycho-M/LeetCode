class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] st = s.split(" ");
        if(pattern.length() != st.length) return false;
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        int i = 0;
        for(char c : pattern.toCharArray()) {
            if(map.containsKey(c)) {
                String curr = map.get(c);
                if(!curr.equals(st[i])) return false;
            } else {
                if(set.contains(st[i])) return false;
                map.put(c, st[i]);
                set.add(st[i]);
            }
            i++;
        }
        return true;
    }
}