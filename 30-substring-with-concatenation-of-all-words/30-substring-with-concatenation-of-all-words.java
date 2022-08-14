class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
//         List<Integer> res = new ArrayList<>();
//         int winSize = words[0].length() * words.length;
//         if(winSize > s.length()) return res;
//         StringBuilder temp = new StringBuilder("");
//         int wLen = words[0].length();
        
//         HashSet<Integer> done = new HashSet<>();
//         getIndexes(wLen, winSize, temp, words, s, res, done);
//         return res;
        
        List<Integer> res = new ArrayList<>();
        int wLen = words[0].length();
        int winSize = wLen * words.length;
        
        Map<String, Integer> freq = new HashMap<>();
        for(String str : words) freq.put(str, freq.getOrDefault(str, 0) + 1);
        
        for(int i = 0; i < s.length() - winSize + 1; i++) {
            String substring = s.substring(i, i + winSize);
            if(isValid(substring, freq, wLen)) res.add(i);
        }
        
        return res;
    }
    
    private boolean isValid(String substring, Map<String, Integer> freq, int wLen) {
        Map<String, Integer> currFreq = new HashMap<>();
        for(int i = 0; i < substring.length(); i += wLen) {
            String temp = substring.substring(i, i + wLen);
            if(!freq.containsKey(temp)) return false;
            currFreq.put(temp, currFreq.getOrDefault(temp, 0) + 1);
        }
        
        return freq.equals(currFreq);
    }
    
    
    
    private void getIndexes(int wLen, int winSize, StringBuilder temp, String[] words, String s, List<Integer> res, HashSet<Integer> done) {
        if(temp.length() == winSize) {
            String curr = temp.toString();
            int index = s.indexOf(curr);
            if(index != -1 && !done.contains(index)) {
                while(index != -1 && !done.contains(index)) {
                    res.add(index);
                    done.add(index);
                    index = s.indexOf(curr, index + 1);
                }
            }
            return;
        }
        
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals("")) continue;
            temp.append(words[i]);
            String w = words[i];
            words[i] = "";
            getIndexes(wLen, winSize, temp, words, s, res, done);
            // System.out.println(temp.length() + " " + temp);
            temp = temp.delete(temp.length() - wLen, temp.length());
            words[i] = w;
        }
    }
}