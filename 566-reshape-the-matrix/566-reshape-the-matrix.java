class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        
        int tot = mat.length * mat[0].length;
        if(tot != r * c) {
            return mat;
        }
        
        int[][] res = new int[r][c];
        int row = 0, col = 0;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                res[i][j] = mat[row][col++];
                if(col == mat[0].length) {
                    row++;
                    col = 0;
                }
            }
        }
        
        return res;
    }
}