class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int count = 1;
        int iUBound = n - 1, iLBound = 0, jUBound = n - 1, jLBound = 0, i = 0, j = 0;
        while(iUBound >= iLBound && jUBound >= jLBound) {
            for(j = jLBound; j <= jUBound; j++) {
                res[i][j] = count;
                count++;
            }
            
            j--;
            if(iLBound == iUBound) break;
            iLBound++;
            
            for(i = iLBound; i <= iUBound; i++) {
                res[i][j] = count;
                count++;
            }
            
            i--;
            if(jUBound == jLBound) break;
            jUBound--;
            
            for(j = jUBound; j >= jLBound; j--) {
                res[i][j] = count;
                count++;
            }
            
            j++;
            if(iUBound == iLBound) break;
            iUBound--;
            
            for(i = iUBound; i >= iLBound; i--) {
                res[i][j] = count;
                count++;
            }
            
            i++;
            jLBound++;
            
        }
        return res;
    }
}