class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
//         Brute force - TLE
        List<List<String>> res = new LinkedList<>();
        
//         if(strs.length == 1) {
//             List<String> list = new ArrayList<>(1);
//             list.add(strs[0]);
//             res.add(list);
//             return res;
//         }
        
//         Set<Integer> set = new HashSet<>();
//         List<String> list;
//         for(int i = 0; i < strs.length; i++) {
//             if(set.contains(i)) continue;
//             set.add(i);
//             list = new LinkedList<>();
//             list.add(strs[i]);
//             for(int j = i + 1; j < strs.length; j++) {
//                 if(set.contains(j)) continue;
//                 if(areAnagrams(strs[i], strs[j])) {
//                     set.add(j);
//                     list.add(strs[j]);
//                 }
//             }
//             res.add(list);
//         }
        
//         return res;
        
        if(strs.length == 1) {
            List<String> list = new ArrayList<>(1);
            list.add(strs[0]);
            res.add(list);
            return res;
        }
        Map<String, List> map = new HashMap<>();
        int[] alph = new int[26];
        for(String s : strs) {
            Arrays.fill(alph, 0);
            for(char c : s.toCharArray()) alph[c - 'a']++;
            
            StringBuilder sb = new StringBuilder("");
            for(int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(alph[i]);
            }
            
            String key = sb.toString();
            if(!map.containsKey(key)) map.put(key, new ArrayList());
            map.get(key).add(s);
        }
        res = new ArrayList(map.values());
        return res;
        
    }
    
    boolean areAnagrams(String s1, String s2) {
        int[] alph = new int[26];
        if(s1.length() != s2.length()) return false;
        for(int i = 0; i < s1.length(); i++) {
            alph[s1.charAt(i) - 'a']++;
            alph[s2.charAt(i) - 'a']--;
        }
        
        for(int n : alph) {
            if(n != 0) return false;
        }
        
        return true;
    }
}