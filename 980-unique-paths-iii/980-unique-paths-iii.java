class Solution {
    final int[] toAdd = {-1, 0, 1, 0, -1};
    public int uniquePathsIII(int[][] grid) {
        int blocks = 0, m = grid.length, n = grid[0].length;
        int[] start = new int[2], end = new int[2];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == -1) blocks++;
                else if(grid[i][j] == 1) start = new int[]{i, j};
                else if(grid[i][j] == 2) end = new int[]{i, j};
            }
        }
        
        grid[start[0]][start[1]] = -1;
        return getPaths(start[0], start[1], blocks, end, grid);
    }
    
    int getPaths(int row, int col, int currBlocks, int[] end, int[][] grid) {
        if(row == end[0] && col == end[1]) {
            if(currBlocks == grid.length * grid[0].length - 1) return 1;
            else return 0;
        }
        int count = 0;
        for(int i = 0; i < 4; i++) {
            int nextRow = row + toAdd[i], nextCol = col + toAdd[i + 1];
            if(nextRow < 0 || nextRow >= grid.length || nextCol < 0 || 
                nextCol >= grid[0].length || grid[nextRow][nextCol] == -1) continue;
            
            grid[nextRow][nextCol] = -1;
            count += getPaths(nextRow, nextCol, currBlocks + 1, end, grid);
            grid[nextRow][nextCol] = 0;
        }   
        
        return count;
    }
}