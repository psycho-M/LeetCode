class Solution {
    public void gameOfLife(int[][] b) {
        int rows = b.length, cols = b[0].length;
        if(rows == 1 && cols == 1) {
            if(b[0][0] == 1) b[0][0] = 0;
            return;
        }
        if(rows == 1 ) {
            int[] copy = new int[cols];
            for(int i = 0; i < cols; i++) {
                if(b[0][i] == 1) {
                    if(i == 0 || i == cols - 1) copy[i] = 0;
                    else if(b[0][i - 1] == 0 || b[0][i + 1] == 0) copy[i] = 0;
                    else copy[i] = 1;
                } else copy[i] = 0;
            }
            b[0] = Arrays.copyOf(copy, cols);
            return;
        }
        if(cols == 1 ) {
            int[] copy = new int[rows];
            for(int i = 0; i < cols; i++) {
                if(b[i][0] == 1) {
                    if(i == 0 || i == rows - 1) copy[i] = 0;
                    else if(b[i - 1][0] == 0 || b[i + 1][0] == 0) copy[i] = 0;
                    else copy[i] = 1;
                } else copy[i] = 0;
            }
            for(int i = 0; i < rows; i++) b[i][0] = copy[i];
            return;
        }
        
        int[][] res = new int[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                int ones = countLiveNeighbours(b, i, j);
                if(b[i][j] == 0) {
                    if(ones == 3) res[i][j] = 1;
                    else res[i][j] = 0;
                } else {
                    if(ones < 2 || ones > 3) res[i][j] = 0;
                    else res[i][j] = 1;
                }
            }
        }
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                b[i][j] = res[i][j];
            }
        }
    }
    
    int countLiveNeighbours(int[][] b, int i, int j) {
        int one = 0;
        if(i > 0 && j > 0 && i < b.length - 1 && j < b[0].length - 1) {
            if(b[i - 1][j] == 1) one++;
            if(b[i - 1][j + 1] == 1) one++;
            if(b[i][j + 1] == 1) one++;
            if(b[i + 1][j + 1] == 1) one++;
            if(b[i + 1][j] == 1) one++;
            if(b[i + 1][j - 1] == 1) one++;
            if(b[i][j - 1] == 1) one++;
            if(b[i - 1][j - 1] == 1) one++;
        } else if(i == 0 && j == 0) {
            if(b[i][j + 1] == 1) one++;
            if(b[i + 1][j + 1] == 1) one++;
            if(b[i + 1][j] == 1) one++;
        } else if(i == 0 && j == b[0].length - 1) {
            if(b[i + 1][j] == 1) one++;
            if(b[i + 1][j - 1] == 1) one++;
            if(b[i][j - 1] == 1) one++;
        } else if(i == b.length - 1 && j == 0) {
            if(b[i - 1][j] == 1) one++;
            if(b[i - 1][j + 1] == 1) one++;
            if(b[i][j + 1] == 1) one++;
        } else if(i == b.length - 1 && j == b[0].length - 1) {
            if(b[i][j - 1] == 1) one++;
            if(b[i - 1][j - 1] == 1) one++;
            if(b[i - 1][j] == 1) one++;
        } else if(i == 0 && j < b[0].length - 1) {
            if(b[i][j + 1] == 1) one++;
            if(b[i + 1][j + 1] == 1) one++;
            if(b[i + 1][j] == 1) one++;
            if(b[i + 1][j - 1] == 1) one++;
            if(b[i][j - 1] == 1) one++;
        } else if(i == b.length - 1 && j < b[0].length - 1) {
            if(b[i - 1][j] == 1) one++;
            if(b[i - 1][j + 1] == 1) one++;
            if(b[i][j + 1] == 1) one++;
            if(b[i][j - 1] == 1) one++;
            if(b[i - 1][j - 1] == 1) one++;
        } else if(j == 0 && i > 0) {
            if(b[i - 1][j] == 1) one++;
            if(b[i - 1][j + 1] == 1) one++;
            if(b[i][j + 1] == 1) one++;
            if(b[i + 1][j + 1] == 1) one++;
            if(b[i + 1][j] == 1) one++;
        } else if(j == b[0].length - 1 && i > 0) {
            if(b[i + 1][j] == 1) one++;
            if(b[i + 1][j - 1] == 1) one++;
            if(b[i][j - 1] == 1) one++;
            if(b[i - 1][j - 1] == 1) one++;
            if(b[i - 1][j] == 1) one++;
        }
        return one;
    }
}