class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i = 0, j = nums.length - 1, temp = 0;
        while(i < j) {
            while(i < j && (nums[i] & 1) == 0) i++;
            while(j > i && (nums[j] & 1) == 1) j--;
            
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }
}