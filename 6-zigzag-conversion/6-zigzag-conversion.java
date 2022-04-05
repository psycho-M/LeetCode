class Solution {
    public String convert(String s, int numRows) {
        int len = s.length();
        
        if(numRows == 1) {
            return s;
        }
        
        char[][] railFence = new char[numRows][len];
        int r = 0, c = 0;
        while(c < len) {
            while(c < len && r < numRows) railFence[r++][c] = s.charAt(c++);
            r -= 2;
            while(c < len && r >= 0) railFence[r--][c] = s.charAt(c++);
            r += 2;
        }
        // print(railFence);
        char[] res = new char[len];
        int k = 0;
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < len; j++) {
                if(railFence[i][j] != '\u0000') res[k++] = railFence[i][j];
            }
        }
        
        return new String(res);
    }
    
    void print(char[][] ch) {
        for(int i = 0; i < ch.length; i++) {
            for(int j = 0; j < ch[0].length; j++) {
                System.out.print(ch[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}