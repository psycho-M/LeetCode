class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int i = 0, j = nums.length - 1, k = j;
        // for(int n : nums) res[i++] = n*n;
        // Arrays.sort(res);
        // return res;
        
        while(i <= j) {
            int one = nums[i] * nums[i];
            int two = nums[j] * nums[j];
            
            if(one > two) {
                res[k--] = one;
                i++;
            } else {
                res[k--] = two;
                j--;
            }
        }
        
        return res;
        
    }
}