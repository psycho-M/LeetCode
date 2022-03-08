class Solution {
    public int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;
        while(fast < nums.length) {
            if(nums[fast] == val) {
                fast++;
            } else {
                nums[slow++] = nums[fast++];
            }
        }
        
        return slow;
        
        
        
        //         int i, j;
//         for(i = 0, j = 0; i < nums.length; j++, i++) {
//             if(nums[i] == val) j--;
//             else nums[j] = nums[i];
//         }
        
//         return j;
    }
}