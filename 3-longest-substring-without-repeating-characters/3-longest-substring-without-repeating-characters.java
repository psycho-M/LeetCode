class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> windowSet = new HashSet<>();
        StringBuilder res = new StringBuilder();
        
        int l = 0, r = 0, n = s.length();
        int max = 0;
        while(r < n) {
            char currR = s.charAt(r);
            if(windowSet.contains(currR)) {
                max = Math.max(max, res.length());
                while(windowSet.contains(currR)) {
                    windowSet.remove(res.charAt(0));
                    res.deleteCharAt(0);
                    l++;
                }
            }
            windowSet.add(currR);
            res.append(currR);
            r++;
        }
        max = Math.max(max, r - l);
        return max;
    }
}