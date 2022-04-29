class Solution {
    public boolean isValidSudoku(char[][] b) {
        HashSet<Character> set;
        
        for(int i = 0; i < 9; i++) {
            set = new HashSet<>();
            for(int j = 0; j < 9; j++) {
                if(b[i][j] == '.') continue;
                if(set.contains(b[i][j])) return false;
                set.add(b[i][j]);
            }
        }
        
        for(int i = 0; i < 9; i++) {
            set = new HashSet<>();
            for(int j = 0; j < 9; j++) {
                if(b[j][i] == '.') continue;
                if(set.contains(b[j][i])) return false;
                set.add(b[j][i]);
            }
            // set.removeAll();
        }
        
        for(int i = 0; i < 9; i += 3) {
            for(int j = 0; j < 9; j += 3) {
                if(!check(b, i, j)) return false;
            }
        }
        
        return true;
    }
    
    boolean check(char[][] b, int r, int c) {
        HashSet<Character> set = new HashSet<>();
        for(int i = r; i < r + 3; i++) {
            for(int j = c; j < c + 3; j++) {
                if(b[i][j] == '.') continue;
                if(set.contains(b[i][j])) return false;
                set.add(b[i][j]);
            }
        }
        return true;
    }
}