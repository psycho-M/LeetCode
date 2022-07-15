class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    removeIslandDFS(grid, i, j);
                }
            }
        }
        return count;
    }
    
    public void removeIslandDFS(char[][] grid, int r, int c) {
        int rLen = grid.length, cLen = grid[0].length;
        if(r < 0 || r >= rLen || c < 0 || c >= cLen || grid[r][c] == '0') return;
        grid[r][c] = '0';
        removeIslandDFS(grid, r + 1, c);
        removeIslandDFS(grid, r - 1, c);
        removeIslandDFS(grid, r, c + 1);
        removeIslandDFS(grid, r, c - 1);
        
    }
    
    
    
}