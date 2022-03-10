class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k == nums.length) return;
        
        int rot = nums.length - k;

        int[] temp1 = new int[k];
        int j = 0, l = 0;
        for(int i = rot; i < nums.length; i++) {
            temp1[j++] = nums[i];
        }    
        int[] temp2 = new int[rot];
        for(int i = 0; i < rot; i++) {
            temp2[i] = nums[i];
        }
        j = 0; 
        l = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i < k) {
                nums[i] = temp1[j++];
            } else {
                nums[i] = temp2[l++];
            }
        }
    }
}