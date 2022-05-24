class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        boolean oddAdded = false;
        int count = 0;
        for(char c : map.keySet()) {
            int curr = map.get(c);
            if((curr & 1) == 1) {
                if(!oddAdded) {
                    count += curr;
                    oddAdded = true;
                } else count += curr - 1;
            } else count += curr;
        }
        
        return count;
    }
}