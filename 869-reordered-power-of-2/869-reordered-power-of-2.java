class Solution {
    public boolean reorderedPowerOf2(int n) {
        String num = String.valueOf(n);
        int[] numCount = countDigits(num);
        // print(numCount);
        int a = 1;
        for(int i = 0; i < 30; i++) {
            int[] temp = countDigits(String.valueOf(a << i));
            int j = 0;
            // print(temp);
            if(Arrays.equals(numCount, temp)) return true;
        }
        return false;
    }
    
    private int[] countDigits(String n) {
        int[] count = new int[10];
        for(char c : n.toCharArray()) count[c - '0']++;
        return count;
    }
    
    void print(int[] arr) {
        System.out.print("[");
        for(int n : arr) System.out.print(n + ", ");
        System.out.println("]");
    }
}