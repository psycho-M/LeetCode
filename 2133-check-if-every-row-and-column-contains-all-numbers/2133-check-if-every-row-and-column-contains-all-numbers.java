class Solution {
    public boolean checkValid(int[][] m) {
        Set<Integer> set;
        int count = 0;
        for(int i = 0; i < m.length; i++) {
            set = new HashSet<>();
            for(int j = 0; j < m[0].length; j++) {
                if(set.contains(m[i][j])) return false;
                set.add(m[i][j]);
            }
            if(set.size() != m.length) return false;
        }
        
        for(int i = 0; i < m.length; i++) {
            set = new HashSet<>();
            for(int j = 0; j < m[0].length; j++) {
                if(set.contains(m[j][i])) return false;
                set.add(m[j][i]);
            }
            if(set.size() != m.length) return false;
        }
        
        return true;
    }
}