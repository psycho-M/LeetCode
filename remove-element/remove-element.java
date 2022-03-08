class Solution {
    /*
        A Two pointer appraoch for inplace modification of the array.
        
        Here we need to remove all the numbers equal to val from array.
        What we do is, we use a slow and a fast pointer.
        We increment fast and slow by one every time we encounter a fast-th element that is not
        equal to val. And put the fast element in place of the slow-th index of array.
        But when we encounter a fast-th element that is equal to val, we only increment fast by one, and
        not slow.
    */
    
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