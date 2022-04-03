// class Solution {
//     public void nextPermutation(int[] nums) {
//         if(nums.length == 1) return;
//         int r = nums.length - 1, l = r - 1, index = 0;
//         while(r > 0 && nums[r - 1] >= nums[r]) {
//             r--;
//         }
//         if(r > 0) {
//             l = r - 1;
//             int min = Integer.MAX_VALUE;
//             while(r < nums.length) {
//                 if(nums[r] > nums[l] && nums[r] <= min) {
//                     min = nums[r];
//                     index = r;
//                 }
//                 r++;
//             }
//             break;
//         }
//         swap(nums, l, index);
//         reverse(nums, l + 1, nums.length - 1);
//     }
    
//     void reverse(int[] nums, int start, int end) {
//         int temp;
//         while(start < end) {
//             temp = nums[start];
//             nums[start] = nums[end];
//             nums[end] = temp;
//             start++;
//             end--;
//         }
//     }
    
//     void swap(int[] nums, int l, int r) {
//         int temp = nums[l];
//         nums[l] = nums[r];
//         nums[r] = temp;
//     }
// }

public class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}