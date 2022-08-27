class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int result = Integer.MIN_VALUE;
        for (int begin = 0; begin < n; begin++) {
            for (int end = begin + 1; end <= n; end++) {
                int[] arr = new int[m];
                for (int i = 0; i < m; i++) {
                    for (int j = begin; j < end; j++) {
                        arr[i] += matrix[i][j];
                    }
                }
                TreeSet<Integer> treeSet = new TreeSet<>();
                treeSet.add(0);
                int cumulative = 0;
                for (int i : arr) {
                    cumulative += i;
                    Integer ceiling = treeSet.ceiling(cumulative - k);
                    if (ceiling != null) {
                        result = Math.max(result, cumulative - ceiling);
                    }
                    treeSet.add(cumulative);
                }
            }
        }
        return result;
    }

}