class Solution {
    public void sortColors(int[] nums) {
        int i = 0, j = 0;
        for(int l = 0; l < 3; l++) {
            j = i + 1;
            while(j < nums.length) {
                if(nums[i] == l) {
                    i++;
                    if(j == i) j++;
                    continue;
                }
                while(j < nums.length && nums[j] != l) j++;
                if(j == nums.length) break;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
                j++;
            }
        }
    }
}