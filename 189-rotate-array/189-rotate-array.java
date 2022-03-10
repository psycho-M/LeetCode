class Solution {
    
    /*
        Two approaches ( there are more )
        First:
            We use additional space to do this. We take all the elements from (length of array - k) to end of 
            array and store it in temp1 array. Then we take all elements from start to (length of array - k) and
            store it in temp2 array.
            Then we combine this array such that we first add temp1 array to the original nums, from
            0th index to (k - 1) index array and then add temp2 array to the rest of the nums array.
            
            Time complexity: O(n)
            Space Complxity: O(n)
            
        Second:
            We use reversing array approach in this one.
            We first reverse the elements from 0th index to (length of array - k)-th index.
            Then reverse (length of array - k)-th index to end of array.
            And finally reverse the whole array.
            Ex: [1,2,3,4,5,6,7]
                First reverse:    [4,3,2,1,5,6,7]
                Second reverse:    [4,3,2,1,7,6,5]
                Third reverse:    [5,6,7,1,2,3,4] - Final k-rotated array.
                
            Time Complexity: O(n)
            Space Complexity: O(1)
    */
    
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k == nums.length) return;
        
        int rot = nums.length - k;
// First
//         int[] temp1 = new int[k];
//         int j = 0, l = 0;
//         for(int i = rot; i < nums.length; i++) {
//             temp1[j++] = nums[i];
//         }    
//         int[] temp2 = new int[rot];
//         for(int i = 0; i < rot; i++) {
//             temp2[i] = nums[i];
//         }
//         j = 0; 
//         l = 0;
//         for(int i = 0; i < nums.length; i++) {
//             if(i < k) {
//                 nums[i] = temp1[j++];
//             } else {
//                 nums[i] = temp2[l++];
//             }
//         }

        
// Second
        reverse(nums, rot, nums.length - 1);
        reverse(nums, 0, rot - 1);
        reverse(nums, 0, nums.length - 1);
    }
    
    private void reverse(int[] nums, int start, int end) {
        int temp;
        while(start < end) {
            temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}