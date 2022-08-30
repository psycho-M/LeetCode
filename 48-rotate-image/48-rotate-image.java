class Solution {
    public void rotate(int[][] m) {
        int n = m.length;
        // int iU = matrix.length - 1, iL = 0, jU = matrix.length - 1, jL = 0;
         /*
            iL = 0, iU = n - 1, jL = 0, jU = n - 1;
            loop from 1 to n / 2
                iLCurr = iL, iUCurr = iU, jLCurr = jL, jUCurr = jU;
                loop k from iL to iU - 1
                    temp = top left => m[iLCurr][jLCurr];
                    top left => m[iLCurr][jLCurr] = bottom left => m[iUCurr][jLCurr];
                    bottom left => m[iUCurr][jLCurr] = bottom right => m[iUCurr][jUCurr];
                    bottom right => m[iUCurr][jUCurr] = top right => m[iLCurr][jUCurr];
                    top right => m[iLCurr][jUCurr] = temp;
                iL++;
                iU--;
                jL++;
                jU--;
         */
        
        // int iL = 0, iU = n - 1, jL = 0, jU = n - 1;
        // for(int i = 1; i < n / 2; i++) {
        //     int iLCurr = iL, iUCurr = iU, jLCurr = jL, jUCurr = jU;
        //     for(int k = iL; k < iU; k++) {
        //         int temp = m[iLCurr][jLCurr];
        //         m[iLCurr][jLCurr] = m[iUCurr][jLCurr];
        //         m[iUCurr][jLCurr] = m[iUCurr][jUCurr];
        //         m[iUCurr][jUCurr] = m[iLCurr][jUCurr];
        //         m[iLCurr][jUCurr] = temp;
        //     }
        //     iL++;
        //     iU--;
        //     jL++;
        //     jU--;
        // }
        
        transpose(m);
        reflect(m);
    }
    
    void transpose(int[][] m) {
        for(int i = 0; i < m.length; i++) {
            for(int j = i + 1; j < m.length; j++) {
                int temp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = temp;
            }
        }
    }
    
    void reflect(int[][] m) {
        for(int[] arr : m) reverse(arr);
    }
    
    void reverse(int[] arr) {
        for(int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }
}