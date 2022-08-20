class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prodFront = new int[nums.length + 1], prodBack = new int[nums.length + 1];
        prodFront[0] = 1;
        prodBack[nums.length] = 1;
        for(int i = 0; i < nums.length; i++) {
            prodFront[i + 1] = prodFront[i] * nums[i];
        }
        for(int i = nums.length - 1; i >= 0; i--) {
            prodBack[i] = prodBack[i + 1] * nums[i];
        }
        int[] res = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++) {
            res[i] = prodBack[i + 1] * prodFront[i];
        }
        
        return res;
    }
}