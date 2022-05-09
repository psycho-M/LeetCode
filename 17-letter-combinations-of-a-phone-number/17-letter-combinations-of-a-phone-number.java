class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if(digits.length() == 0) return res;
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        res.add("");
        for(int i = 0; i < digits.length(); i++) {
            char c = digits.charAt(i);
            int size = res.size();
            for(int j = 0; j < size; j++) {
                String curr = res.remove();
                for(char ch : map.get(c).toCharArray()) res.add(curr + ch);
            }
        }
        
        return res;
    }
}