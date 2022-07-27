class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        palindromePartitioning(0, new ArrayList<>(), s, res, set);
        return res;
    }
    
    private void palindromePartitioning(int curr, List<String> currList, String s, 
                           List<List<String>> res, Set<String> set) {
        if(curr == s.length()) {
            res.add(new ArrayList<>(currList));
            return;
        }
        
        for(int i = curr + 1; i <= s.length(); i++) {
            String temp = s.substring(curr, i);
            if(set.contains(temp)) {
                currList.add(temp);
                palindromePartitioning(i, currList, s, res, set);
                currList.remove(currList.size() - 1);
            } else if(isPalindrome(temp)) {
                currList.add(temp);
                palindromePartitioning(i, currList, s, res, set);
                currList.remove(currList.size() - 1);
                set.add(temp);
            }
        }
    }
    
    private boolean isPalindrome(String s) {
        if(s.length() < 2) return true;
        int i = 0, j = s.length() - 1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}