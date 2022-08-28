class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        
        for(int i = m - 1; i >= 0; i--) {
            List<Integer> temp = new ArrayList<>();
            for(int r = i, c = 0; r < m && c < n; r++, c++) {
                temp.add(mat[r][c]);
            }
            Collections.sort(temp);
            int j = 0;
            for(int r = i, c = 0; r < m && c < n; r++, c++) {
                mat[r][c] = temp.get(j++);
            }
        }
        
        for(int j = 1; j < n; j++) {
            List<Integer> temp = new ArrayList<>();
            for(int r = 0, c = j; r < m && c < n; r++, c++) {
                temp.add(mat[r][c]);
            }
            Collections.sort(temp);
            int i = 0;
            for(int r = 0, c = j; r < m && c < n; r++, c++) {
                mat[r][c] = temp.get(i++);
            }
        }
        
        return mat;
    }
}