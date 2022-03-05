class Solution {
    
    /*
        This was tricky when I first tried it, but when i tried it the second time after
        a gap of a few month, it was easier.
        
        Here what we do is keep track of the current upper and lower bounds of row and column.
        i for row and j for column.
        
        We start by traversing from left to write, and then increasing the row lower bound
        because we will never be visiting the first row.
        Similarly when we go from top to bottom, we decrease the column upper bound, as we will 
        never be traversing that column.
        Similarly for the row Upper bound and column upper bound.
        
        after every linear traversal, we check if the upper bound and lower bound of the
        row or column are equal, if equal, we stop further traversal as we have visited all the
        elements of the matrix in a spiral.
    */
    
    
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        // res.add(matrix[0][0]);
        int i = 0, j = 0, iUBound = matrix.length - 1, iLBound = 0, jUBound = matrix[0].length - 1, jLBound = 0;
        while(iUBound >= iLBound && jUBound >= jLBound) {
            // System.out.println("iU = " + iUBound + ", jU = " + jUBound + ", iL = " + iLBound + ", jL = " + jLBound);
            
            for(j = jLBound; j <= jUBound; j++) {
                res.add(matrix[i][j]);
            }
            // System.out.println(res);
            
            j--;
            if(iLBound++ == iUBound) break;
            
            
            for(i = iLBound; i <= iUBound; i++) {
                res.add(matrix[i][j]);
            }
            // System.out.println(res);
            
            i--;
            if(jUBound-- == jLBound) break;
            
            for(j = jUBound; j >= jLBound; j--) {
                res.add(matrix[i][j]);
            }
            // System.out.println(res);
            
            j++;
            if(iUBound-- == iLBound) break;
            
            for(i = iUBound; i >= iLBound; i--) {
                res.add(matrix[i][j]);
            }
            // System.out.println(res);
            
            i++;
            jLBound++;
        }
        
        return res;
    }
}