class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        
        int i = 0, j = tokens.length - 1;
        int score = 0, max = 0;
        
        while(i <= j) {
            if(power >= tokens[i]) {
                power -= tokens[i];
                score++;
                i++;
                max = Math.max(score, max);
            } else if(score >= 1) {
                power += tokens[j];
                score--;
                j--;
            } else break;
        }
        
        return max;
    }
}