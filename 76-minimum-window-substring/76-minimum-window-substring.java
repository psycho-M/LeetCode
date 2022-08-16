class Solution {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length(), min = m;
        
        if(m < n) return "";
        
        Map<Character, Integer> tFreq = new HashMap<>();
        for(char c : t.toCharArray()) tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        // System.out.println(tFreq);
        Map<Character, Integer> sFreq = new HashMap<>();
        String res = "";
        int l = 0, r = 0;
        // System.out.println(m);
        while(r < m) {
            char currR = s.charAt(r);
            sFreq.put(currR, sFreq.getOrDefault(currR, 0) + 1);
            // System.out.println(sFreq);
            while(containsAll(tFreq, sFreq)) {
                char c = s.charAt(l);
                
                // System.out.println(l + " " + r);
                if(sFreq.get(c).equals(tFreq.get(c))) {
                    if(min > r - l) {
                        res = s.substring(l, r + 1);
                        min = r - l;
                        // System.out.println(res);
                    }
                    break;
                } else {
                    sFreq.put(c, sFreq.get(c) - 1);
                    if(sFreq.get(c) == 0) sFreq.remove(c);
                    l++;
                }
            }
            r++;
        }
        
        // System.out.println(l + " " + r);
        System.out.println(sFreq);
        if(containsAll(tFreq, sFreq) && min > r - l) res = s.substring(l, r);
        
        return res;
    }
    
    private boolean containsAll(Map<Character, Integer> tFreq, Map<Character, Integer> sFreq) {
        for(char c : tFreq.keySet()) {
            if((int)sFreq.getOrDefault(c, 0) < (int)tFreq.get(c)) return false;
        }

        return true;
    }
    
}