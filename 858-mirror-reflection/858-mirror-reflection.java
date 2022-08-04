class Solution {
    public int mirrorReflection(int p, int q) {
        int i = 1, j = 1;
        while(i * p != j * q) {
            j++;
            i = j * q / p;
        }
        if(i % 2 == 0 && j % 2 == 1) return 0;
        else if(i % 2 ==1 && j % 2 == 1) return 1;
        else if(i % 2 == 1 && j % 2 == 0) return 2;
        else return -1;
    }
}