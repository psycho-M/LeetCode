class Solution {
    public void moveZeroes(int[] nums) {
        int[] temp = new int[nums.length];
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) temp[j++] = nums[i];
        }
        
        for(int i = 0; i < temp.length; i++) {
            nums[i] = temp[i];
        }
        
        
    }
}