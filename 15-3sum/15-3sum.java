class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
//         Brute force - TLE
//         int n = nums.length;
//         if(n == 0) return new ArrayList<>();
//         List<List<Integer>> res = new LinkedList<>();
//         HashSet<List<Integer>> set = new HashSet<>();
//         for(int i = 0; i < n; i++) {
//             for(int j = i + 1; j < n; j++) {
//                 for(int k = j + 1; k < n; k++) {
//                     if(nums[i] + nums[j] + nums[k] == 0) {
//                         List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
//                         Collections.sort(temp);
//                         set.add(temp);
//                     }
//                 }
//             }
//         }
        
//         for(List<Integer> i : set) res.add(i);
        
//         return res;
        
        Arrays.sort(arr);
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) break; // Since arr[i] <= arr[l] <= arr[r], if a[i] > 0 then sum=arr[i]+arr[l]+arr[r] > 0
            int l = i + 1, r = n - 1;
            while (l < r) {
                int sum = arr[i] + arr[l] + arr[r];
                if (sum < 0) l++;
                else if (sum > 0) r--;
                else {
                    ans.add(Arrays.asList(arr[i], arr[l], arr[r]));
                    while (l+1 <= r && arr[l] == arr[l+1]) l++; // Skip duplicate nums[l]
                    l++;
                    r--;
                }
            }
            while (i+1 < n && arr[i+1] == arr[i]) i++; // Skip duplicate nums[i]
        }
        return ans;
    }
}