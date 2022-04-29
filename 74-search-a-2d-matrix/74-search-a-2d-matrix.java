class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;
        while(i < matrix.length && j >= 0) {
            if(matrix[i][j] == target)
                return true;
            else if(matrix[i][j] > target)
                j--;
            else if(matrix[i][j] < target)
                i++;
        }
        return false;
    }
    
    boolean binarySearch(int arr[], int target) {
        int l = 0, r = arr.length - 1, m;
        while(l < r) {
            m = (l + r) / 2;
            if(arr[m] == target) return true;
            else if(arr[m] > target) r = m - 1;
            else l = m + 1;
        }
        return false;
    }
}