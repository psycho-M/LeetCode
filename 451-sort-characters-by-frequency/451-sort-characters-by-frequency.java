class Solution {
    public String frequencySort(String s) {
        //bucket sort
        char[] ch = s.toCharArray();
        
        Map<Character, Integer> alph = new HashMap<>();
        
        for(char c : ch) alph.put(c, alph.getOrDefault(c, 0) + 1);
        
        List<Character>[] bucket = new List[ch.length + 1];
        
        for(char c : alph.keySet()) {
            int freq = alph.get(c);
            if(bucket[freq] == null) bucket[freq] = new ArrayList<Character>();
            bucket[freq].add(c);
        }
        
        StringBuilder res = new StringBuilder(ch.length + 1);
        
        for(int i = ch.length; i >= 0; i--) {
            if(bucket[i] == null) continue;
            
            for(char c : bucket[i]) {
                for(int j = 0; j < i; j++) res.append(c);
            }
        }
        
        return res.toString();
    }
}