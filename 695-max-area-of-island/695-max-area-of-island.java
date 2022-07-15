class Solution {
    final int[] dir = {0, 1, 0, -1, 0};
    
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) res = Math.max(res, bfs(grid, i, j));
            }
        }
        
        return res;
    }
    
    public int bfs(int[][] grid, int r, int c) {
        int rLen = grid.length, cLen = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        grid[r][c] = 0;
        int res = 1;
        
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            for(int i = 0; i < 4; i++) {
                int nr = temp[0] + dir[i], nc = temp[1] + dir[i + 1];
                if(nr < 0 || nr == rLen || nc < 0 || nc == cLen || grid[nr][nc] == 0) continue;
                q.offer(new int[]{nr, nc});
                grid[nr][nc] = 0;
                res++;
            }
        }
        return res;
    }
}