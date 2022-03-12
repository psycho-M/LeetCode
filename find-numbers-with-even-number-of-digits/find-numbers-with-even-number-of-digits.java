class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int n : nums) {
            int len = String.valueOf(n).length();
            if((len & 1) == 0) count++;
        }
        
        return count;
    }
}