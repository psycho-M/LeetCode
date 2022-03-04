class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if(mat.length == 1) return mat[0];
        if(mat[0].length == 1) {
            int[] res = new int[mat.length];
            int k = 0;
            for(int[] n : mat) res[k++] = n[0];
        }
        
        int m = mat.length - 1, n = mat[0].length - 1;
        
        int[] res = new int[(m + 1) * (n + 1)];
        // res[0] = mat[0][0];
        int i = 0, j = 0, k = 0;
        boolean up = true;
        while(true) {
            
            if(!up) {
                while(j >= 0 && i <= m) {
                    res[k++] = mat[i++][j--];
                }
                if(i > m) {
                    i = m;
                    j++;
                }
                j++;
            } else {            
                while(i >= 0 && j <= n) {
                    res[k++] = mat[i--][j++];
                }
                if(j > n) {
                    j = n;
                    i++;
                }
                i++;
            }
            if(i == m && j == n) {
                res[k] = mat[m][n];
                break;
            }
            up = !up;
            
        }
        
        return res;
    }
}