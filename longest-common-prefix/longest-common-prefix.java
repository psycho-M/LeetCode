class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1 || strs[0].equals("")) return strs[0];
        
        int i = 0, count = 0;
        boolean isValid = true;
        for(char c : strs[0].toCharArray()) {
            for(String s : strs) {
                if(s.equals("") || i == s.length()) return s;
                if(s.charAt(i) != c) isValid = false;
            }
            if(!isValid) break;
            count++;
            i++;
            System.out.println(count);
        }
        
        return count == strs[0].length() ? strs[0] : strs[0].substring(0, count);
      
//         if(strs.length == 1 || strs[0].equals("")) return strs[0];
        
//         int count = 0, i = 0;
//         boolean isValid = true;
//         while(isValid) {
//             char c = strs[0].charAt(i);
//             // int j = i;
//             for(String s : strs) {
//                 if(s.equals("")) return "";
//                 if(s.charAt(i) != c) isValid = false;
//             }
//             count++;
//             i++;
//         }
        
//         return strs[0].substring(0, count - 1);
        
        
    }
}