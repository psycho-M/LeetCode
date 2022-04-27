class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> res = new ArrayList<>();
        
        int i = 0, j = 0;
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i++;
                j++;
            } else if(nums1[i] < nums2[j]) i++;
            else j++;
        }
        
        int[] ans = new int[res.size()];
        i = 0;
        for(int n : res) {
            ans[i++] = n;
        }
        return ans;
    }
    
    // void solve(int[] nums1, int[] nums2, int len)
}