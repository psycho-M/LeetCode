class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[] numsOfSolds = new int[mat.length];
        for(int i = 0; i < m; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) break;
                else count++;
            }
            numsOfSolds[i] = count;
        }
        int[] temp = Arrays.copyOf(numsOfSolds, m);
        Arrays.sort(temp);
        int[] res = new int[k];
        for(int i = 0; i < k; i++) {
            int currSolds = temp[i];
            for(int j = 0; j < m; j++) {
                if(currSolds == numsOfSolds[j]) {
                    res[i] = j;
                    numsOfSolds[j] = -1;
                    break;
                }
            }
        }
        return res;
    }
}