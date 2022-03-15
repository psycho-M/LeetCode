class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // if(m == 0) {
        //     nums1 = nums2;
        //     return;
        // }
        // if(n == 0) {
        //     return;
        // }
        int[] temp = Arrays.copyOf(nums1, m);
        // int[] res = new int[m + n];
        int i = 0, j = 0, k = 0;
        while(i < m && j < n) {
            if(temp[i] < nums2[j]) nums1[k++] = temp[i++];
            else nums1[k++] = nums2[j++];
        }
        
        while(i < m) nums1[k++] = temp[i++];
        
        while(j < n) nums1[k++] = nums2[j++];
        
        // nums1 = res;
        // return nums1;
    }
}