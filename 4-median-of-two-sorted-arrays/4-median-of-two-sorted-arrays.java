class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length - 1, n = nums2.length - 1;
        double median = 0.0;
        if(nums1.length == 0) {
            if((n & 1) == 0) median = (double)nums2[n / 2];
            else median = (double)(nums2[n / 2] + nums2[n / 2 + 1]) / 2;
        } else if(nums2.length == 0) {
            if((m & 1) == 0) median = (double)nums1[m / 2];
            else median = (nums1[m / 2] + (double)nums1[m / 2 + 1]) / 2;
        } else {
            int[] merged = new int[m + n + 2];
            mergeArrays(nums1, nums2, m, n, merged);
        
            int mergeLen = merged.length - 1;
        
            if((mergeLen & 1) == 0) median = (double)merged[mergeLen / 2];
            else median = (double)(merged[mergeLen / 2] + merged[mergeLen / 2 + 1]) / 2;
        }
        return median;
    }
    
    public void mergeArrays(int[] n1, int[] n2, int m, int n, int[] merged) {
        int i = 0, j = 0, k = 0;
        while(i <= m && j <= n) {
            if(n1[i] < n2[j]) merged[k++] = n1[i++];
            else merged[k++] = n2[j++];
        }
        
        while(i <= m) merged[k++] = n1[i++];
        
        while(j <= n) merged[k++] = n2[j++];
        
        // print(merged);
        
    }
    
    public void print(int[] arr) {
        System.out.print("[");
        for(int n : arr) System.out.print(n + ", ");
        System.out.println("]");
    }
}