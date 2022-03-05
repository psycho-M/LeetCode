class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        // res.add(matrix[0][0]);
        int i = 0, j = 0, iUBound = matrix.length - 1, iLBound = 0, jUBound = matrix[0].length - 1, jLBound = 0;
        while(iUBound >= iLBound && jUBound >= jLBound) {
            System.out.println("iU = " + iUBound + ", jU = " + jUBound + ", iL = " + iLBound + ", jL = " + jLBound);
            
            for(j = jLBound; j <= jUBound; j++) {
                res.add(matrix[i][j]);
            }
            System.out.println(res);
            
            j--;
            if(iLBound++ == iUBound) break;
            
            
            for(i = iLBound; i <= iUBound; i++) {
                res.add(matrix[i][j]);
            }
            System.out.println(res);
            
            i--;
            if(jUBound-- == jLBound) break;
            
            for(j = jUBound; j >= jLBound; j--) {
                res.add(matrix[i][j]);
            }
            System.out.println(res);
            
            j++;
            if(iUBound-- == iLBound) break;
            
            for(i = iUBound; i >= iLBound; i--) {
                res.add(matrix[i][j]);
            }
            System.out.println(res);
            
            i++;
            jLBound++;
        }
        
        return res;
    }
}