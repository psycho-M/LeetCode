class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1, curr, count = 0;
        while(i < j) {
            curr = nums[i] + nums[j];
            if(curr == k) {
                count++;
                i++;
                j--;
            } else if(curr < k) i++;
            else j--;
        }
        
        return count;
    }
}