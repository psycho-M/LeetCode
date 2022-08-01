class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = 0;
        return getPaths(0, 0, dp, m, n);
    }
    
    private int getPaths(int row, int col, int[][] dp, int maxRow, int maxCol) {
        if(row == maxRow || col == maxCol) return 0;
        if(row == maxRow - 1 && col == maxCol - 1) return 1;
        
        if(dp[row][col] > 0) return dp[row][col];
        
        dp[row][col] = getPaths(row, col + 1, dp, maxRow, maxCol) + getPaths(row + 1, col, dp, maxRow, maxCol);
        return dp[row][col];
    }
}