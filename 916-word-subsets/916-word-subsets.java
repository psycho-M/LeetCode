// class Solution {
//     public List<String> wordSubsets(String[] w1, String[] w2) {
//         List<String> res = new ArrayList<>(w1.length);
//         int[][] w1Freq = new int[w1.length][26], w2Freq = new int[w2.length][26];
        
//         int i = 0, j = 0;
//         while(i < w1.length || j < w2.length) {
//             if(i < w1.length) findFreq(i, w1, w1Freq);
//             if(j < w2.length) findFreq(j, w2, w2Freq);
//             i++;
//             j++;
//         }
        
//         for(i = 0; i < w1.length; i++) {
//             if(isUniversal(w1Freq[i], w2Freq)) res.add(w1[i]);
//         }
        
//         return res;
//     }
    
//     private void findFreq(int i, String[] words, int[][] wFreq) {
//         for(char c : words[i].toCharArray()) wFreq[i][c - 'a']++;
//     }
    
//     private boolean isUniversal(int[] wFreq, int[][] w2Freq) {
//         for(int j = 0; j < w2Freq.length; j++) {
//             if(!isSubset(w2Freq[j], wFreq)) return false;
//         }
        
//         return true;
//     }
    
//     private boolean isSubset(int[] w1, int[] w2) {
//         for(int i = 0; i < 26; i++) {
//             if(w1[i] > w2[i]) return false;
//         }
        
//         return true;
//     }
// }


class Solution {
    
    private void getFreq(String s, int[] freq) {
        for(char c : s.toCharArray()) freq[c - 'a']++;
    }
    
    private boolean isSubset(int[] w2Freq, int[] w1Freq) {
        for(int i = 0; i < 26; i++) {
            if(w2Freq[i] > w1Freq[i]) return false;
        }
        
        return true;
    }
    
    public List<String> wordSubsets(String[] w1, String[] w2) {
        int[][] w1Freq = new int[w1.length][26];
        int[] maxFreq = new int[26];
        
        int i = 0;
        
        for(String s : w1) {
            getFreq(s, w1Freq[i++]);
        }
        
        for(String s : w2) {
            int[] tempFreq = new int[26];
            for(char c : s.toCharArray()) {
                tempFreq[c - 'a']++;
                maxFreq[c - 'a'] = Math.max(maxFreq[c - 'a'], tempFreq[c - 'a']);
            }
        }
        
        List<String> res = new ArrayList<>();
        
        for(i = 0; i < w1.length; i++) {
            if(isSubset(maxFreq, w1Freq[i])) res.add(w1[i]);
        }
        
        return res;
    }
}