class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);
        
        int sum = 0;
        int curr;
        for(int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            curr = roman.get(c);
            if(i > 0 && roman.get(s.charAt(i - 1)) < roman.get(c)) {
                i--;
                curr -= roman.get(s.charAt(i));
            }
            
            sum += curr;
        }
        
        return sum;
    }
}