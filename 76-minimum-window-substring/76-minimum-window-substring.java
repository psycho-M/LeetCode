// class Solution {
//     public String minWindow(String s, String t) {
//         int m = s.length(), n = t.length(), min = m;
        
//         if(m < n) return "";
        
//         Map<Character, Integer> tFreq = new HashMap<>();
//         for(char c : t.toCharArray()) tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
//         Map<Character, Integer> sFreq = new HashMap<>();
//         String res = "";
//         int l = 0, r = 0;
//         while(r < m) {
//             char currR = s.charAt(r);
//             sFreq.put(currR, sFreq.getOrDefault(currR, 0) + 1);
//             while(containsAll(tFreq, sFreq)) {
//                 char c = s.charAt(l);
                
//                 if(sFreq.get(c).equals(tFreq.get(c))) {
//                     if(min > r - l) {
//                         res = s.substring(l, r + 1);
//                         min = r - l;
//                     }
//                     break;
//                 } else {
//                     sFreq.put(c, sFreq.get(c) - 1);
//                     if(sFreq.get(c) == 0) sFreq.remove(c);
//                     l++;
//                 }
//             }
//             r++;
//         }
        
//         System.out.println(sFreq);
//         if(containsAll(tFreq, sFreq) && min > r - l) res = s.substring(l, r);
        
//         return res;
//     }
    
//     private boolean containsAll(Map<Character, Integer> tFreq, Map<Character, Integer> sFreq) {
//         for(char c : tFreq.keySet()) {
//             if((int)sFreq.getOrDefault(c, 0) < (int)tFreq.get(c)) return false;
//         }

//         return true;
//     }
    
// }

class Solution {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length(), min = m;
        
        if(m < n) return "";
        
        int[] tFreq = new int[123];
        for(char c : t.toCharArray()) tFreq[c]++;
        int[] sFreq = new int[123];
        String res = "";
        int l = 0, r = 0, minL = 0, minR = 0;
        while(r < m) {
            char currR = s.charAt(r);
            sFreq[currR]++;
            while(containsAll(tFreq, sFreq)) {
                char c = s.charAt(l);
                
                if(sFreq[c] == tFreq[c]) {
                    if(min > r - l) {
                        // res = s.substring(l, r + 1);
                        minL = l;
                        minR = r + 1;
                        min = r - l;
                    }
                    break;
                } else {
                    sFreq[c]--;
                    // if(sFreq.get(c) == 0) sFreq.remove(c);
                    l++;
                }
            }
            r++;
        }
        
        // System.out.println(sFreq);
        if(containsAll(tFreq, sFreq) && min > r - l) res = s.substring(l, r);
        // System.out.println(s.substring(minL, minR) + " " + res);
        return s.substring(minL, minR);
    }
    
    private boolean containsAll(int[] tFreq, int[] sFreq) {
        for(int i = 65; i < 123; i++) {
            
            if(tFreq[i] > 0 && sFreq[i] < tFreq[i]) return false;
        }

        return true;
    }
    
}