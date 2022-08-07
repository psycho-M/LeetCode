class Solution {
    int mod = (int)1e9 + 7;
    public int countVowelPermutation(int n) {
        // if(n == 1) return 5;
        long[][] dp = new long[n + 1][26];
        long res = 0;
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        for(int i = 0; i < 5; i++) res = (res + count(n, vowels[i], dp)) % mod;
        return (int)res;
    }
    
    private long count(int n, char c, long[][] dp) {
        if(n == 1) return 1; 
        
        if(dp[n][c - 'a'] != 0) return dp[n][c - 'a'];
        
        if(c == 'a') {
            dp[n][c - 'a'] = count(n - 1, 'e', dp) % mod;
        } else if(c == 'e') {
            dp[n][c - 'a'] = (count(n - 1, 'a', dp) + count(n - 1, 'i', dp)) % mod;
        } else if(c == 'i') {
            dp[n][c - 'a'] = (count(n - 1, 'a', dp) % mod + count(n - 1, 'e', dp) % mod +
                                count(n - 1, 'o', dp) % mod + count(n - 1, 'u', dp) % mod) % mod;
        } else if(c == 'o') {
            dp[n][c - 'a'] = (count(n - 1, 'i', dp) % mod + count(n - 1, 'u', dp) % mod) % mod;
        } else {
            dp[n][c - 'a'] = count(n - 1, 'a', dp) % mod;
        }
        
        return dp[n][c - 'a'];
    }
}