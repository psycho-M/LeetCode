class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        // Set<Integer> row = new HashSet<>(), lTopDiag = new HashSet<>(), lBotDiag = new HashSet<>();
        int[] row = new int[n], lTopDiag = new int[2 * n - 1], lBotDiag = new int[2 * n - 1];
        List<String> ds = new ArrayList<>(n);
        for(int i = 0; i < n; i++) ds.add(".".repeat(n));
        calculateNQueens(0, ds, n, row, lTopDiag, lBotDiag, res);
        return res;
    }
    
    void calculateNQueens(int col, List<String> ds, int n, int[] row, int[] lTopDiag, int[] lBotDiag,
                         List<List<String>> res) {
        if(col == row.length) {
            res.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i = 0; i < row.length; i++) {
            if(row[i] == 1 || lTopDiag[n - 1 + col - i] == 1 || lBotDiag[i + col] == 1) continue;
            
            row[i] = 1;
            lTopDiag[n - 1 + col - i] = 1;
            lBotDiag[i + col] = 1;
            String currRow = ds.get(i);
            ds.set(i, currRow.substring(0, col) + "Q" + currRow.substring(col + 1));
            calculateNQueens(col + 1, ds, n, row, lTopDiag, lBotDiag, res);
            ds.set(i, currRow);
            row[i] = 0;
            lTopDiag[n - 1 + col - i] = 0;
            lBotDiag[i + col] = 0;
        }
    }
}