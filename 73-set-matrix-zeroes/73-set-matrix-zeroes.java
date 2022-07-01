class Solution {
    public void setZeroes(int[][] m) {
        HashSet<Integer> rs = new HashSet<>();
        HashSet<Integer> cs = new HashSet<>();
        for(int i = 0; i < m.length; i++) {
            for(int j = 0; j < m[i].length; j++) {
                if(m[i][j] == 0) {
                    rs.add(i);
                    cs.add(j);
                }
            }
        }
        
        for(int i : rs) {
            for(int j = 0; j < m[i].length; j++) m[i][j] = 0;
        }
        
        for(int j : cs) {
            for(int i = 0; i < m.length; i++) m[i][j] = 0;
        }
        
    }
}