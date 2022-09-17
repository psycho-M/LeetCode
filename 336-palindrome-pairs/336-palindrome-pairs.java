class Solution {
//     public List<List<Integer>> palindromePairs(String[] words) {
//         Map<Character, List<String>> map = new HashMap<>();
//         Map<String, Integer> index = new HashMap<>();
        
//         for(int i = 0; i < words.length; i++) {
//             if(map.containsKey(words[i].charAt(0))) {
//                 map.get(words[i].charAt(0)).add(words[i]);
//             } else {
//                 map.put(words[i].charAt(0), new ArrayList<>());
//                 map.get(words[i].charAt(0)).add(words[i]);
//             }
//             index.put(words[i], i);
//         }
        
//         System.out.println(map);
//         System.out.println(index);
        
//         List<List<Integer>> list = new ArrayList<>();
        
//         for(char c : map.keySet()) {
//             for(String str : map.get(c)) {
//                 char end = str.charAt(str.length() - 1);
//                 for(String s : map.get(end)) {
//                     if(s.equals(str)) continue;
//                     if(isPalindrome(str + s)) {
//                         List<Integer> curr = new ArrayList<>(2);
//                         curr.add(index.get(str));
//                         curr.add(index.get(s));
//                         list.add(curr);
//                     }
//                 }
//             }
//         }
        
//         return list;
//     }
    
//     boolean isPalindrome(String s) {
//         int len = s.length();
//         char[] sChar = s.toCharArray();
//         int i = 0, j = len - 1;
//         while(i < j){
//             if(sChar[i++] != sChar[j--]) return false;
//         }
//         return true;
//     }
    
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ret = new ArrayList<>(); 
        if (words == null || words.length < 2) return ret;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i=0; i<words.length; i++) map.put(words[i], i);
        for (int i=0; i<words.length; i++) {
            // System.out.println(words[i]);
            for (int j=0; j<=words[i].length(); j++) { // notice it should be "j <= words[i].length()"
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                if (isPalindrome(str1)) {
                    String str2rvs = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(str2rvs) && map.get(str2rvs) != i) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(map.get(str2rvs));
                        list.add(i);
                        ret.add(list);
                        // System.out.printf("isPal(str1): %s\n", list.toString());
                    }
                }
                if (isPalindrome(str2)) {
                    String str1rvs = new StringBuilder(str1).reverse().toString();
                    // check "str.length() != 0" to avoid duplicates
                    if (map.containsKey(str1rvs) && map.get(str1rvs) != i && str2.length()!=0) { 
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(i);
                        list.add(map.get(str1rvs));
                        ret.add(list);
                        // System.out.printf("isPal(str2): %s\n", list.toString());
                    }
                }
            }
        }
        return ret;
    }

    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {
            if (str.charAt(left++) !=  str.charAt(right--)) return false;
        }
        return true;
    }
}