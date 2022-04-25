class Solution {
    
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums) {
            if(set.contains(n)) return true;
            set.add(n);
        }
        return false;
    }
    
//     public boolean containsDuplicate(int[] nums) {
//         int[] res = new int[nums.length];
//         topDownMergeSort(nums, 0, nums.length, res);
//         for(int i = 0; i < nums.length - 1; i++) {
//             if(nums[i] == nums[i + 1]) return true;
//         }
//         return false;
//     }
    
//     void topDownMergeSort(int[] nums, int l, int r, int[] res) {
//         if(r - l != 1) {
//             int m = (r + l) / 2;
//             topDownMergeSort(nums, l, m, res);
//             topDownMergeSort(nums, m, r, res);
            
//             merge(nums, l, m, r, res);
//         }
//     }
    
//     void merge(int[] nums, int l, int m, int r, int[] res) {
//         int x = l, y = m, i = l;
//         while(x < m && y < r) {
//             if(nums[x] < nums[y]) res[i++] = nums[x++];
//             else res[i++] = nums[y++];
//         }
        
//         while(x < m) res[i++] = nums[x++];
        
//         while(y < r) res[i++] = nums[y++];
        
//         for(i = l; i < r; i++) {
//             nums[i] = res[i];
//         }
//     }
    
}