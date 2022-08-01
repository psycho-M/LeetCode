class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = 1;
        
        for(int i = 0; i < m - 1; i++) dp[i][n - 1] = 1;
        for(int j = 0; j < n - 1; j++) dp[m - 1][j] = 1;
        
        int count = 0;
        
        for(int i = m - 2, j = n - 2; i >= 0 && j >= 0;) {
            int temp = i;
            
            while(temp >= 0) {
                dp[temp][j] = dp[temp + 1][j] + dp[temp][j + 1];
                temp--;
            }
            temp = j - 1;
            while(temp >= 0) {
                dp[i][temp] = dp[i + 1][temp] + dp[i][temp + 1];
                temp--;
            }
            
            j--;
            i--;
        }
        
        // return getPaths(0, 0, dp, m, n);
        return dp[0][0];
    }
    
    private int getPaths(int row, int col, int[][] dp, int maxRow, int maxCol) {
        if(row == maxRow || col == maxCol) return 0;
        if(row == maxRow - 1 && col == maxCol - 1) return 1;
        
        if(dp[row][col] > 0) return dp[row][col];
        
        dp[row][col] = getPaths(row, col + 1, dp, maxRow, maxCol) + getPaths(row + 1, col, dp, maxRow, maxCol);
        return dp[row][col];
    }
}