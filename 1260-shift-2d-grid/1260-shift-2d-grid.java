class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        // List<List<Integer>> res = new ArrayList<List<Integer>>(grid.length);
        // int rowLen = grid.length, colLen = grid[0].length;
        // for(int i = 0; i < rowLen; i++) {
        //     res.add(new ArrayList<Integer>(Collections.nCopies(colLen, 0)));
        // }
        // for(int i = 0; i < grid.length; i++) {
        //     for(int j = 0; j < grid[0].length; j++) {
        //         int tot =  + k;
        //         int newI = tot / rowLen;
        //         int newJ = tot % colLen;
        //         res.get(newI).set(newJ, grid[i][j]);
        //     }
        // }
        // return res;
        List<List<Integer>> result = new ArrayList();
        int rows = grid.length, col = grid[0].length;

        for (int r = 0; r < rows; r++)
            result.add(new ArrayList());
        k %= (rows * col);
        int dimension = rows * col;
        int begin = dimension - k;
        int x = 0;
        for (int i = begin; i < begin + dimension; i++) {
            int r = (i / col) % rows, c = i % col;
            result.get(x / col).add(grid[r][c]);
            x++;
        }
        return result;
    }
}