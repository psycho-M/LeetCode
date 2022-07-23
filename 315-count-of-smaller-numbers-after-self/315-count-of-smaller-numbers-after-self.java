class Solution {
    
    /*
        We use divide and conquer with merge sort
        We do everything same as merge sort algorithn, the only difference is we 
        merge sort the indexes of the original nums array.
        We create a new array idx which contains indexes from 0 to n - 1.
        Now we map the original values of nums through this idx array in the merge step.
        We also keep a count of the number of elements merged from right array to before the left array
        and then add the count to the count array of indexes when an element of left
        array is being merged.
    */
    
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>(nums.length + 1);
        
        int[] idx = new int[nums.length], temp = new int[nums.length], count = new int[nums.length];
        
        Arrays.fill(count, 0);
        
        for(int i = 0; i < nums.length; i++) idx[i] = i;
        
        mergeSort(idx, 0, nums.length - 1, nums, temp, count);
        
        for(int i : count) res.add(i);
        
        return res;
    }
    
    public void mergeSort(int[] idx, int l, int r, int[] nums, int[] temp, int[] count) {
        if(l >= r) return;
        
        int m = (l + r) / 2;
        mergeSort(idx, l, m, nums, temp, count);
        mergeSort(idx, m + 1, r, nums, temp, count);
        merge(idx, l, m + 1, r, nums, temp, count);
    }
    
    public void merge(int[] idx, int l, int m, int r, int[] nums, int[] temp, int[] count) {
        int i = l, j = m, k = l, rightCount = 0;
        while(i <= m - 1 && j <= r) {
            if(nums[idx[i]] > nums[idx[j]]) {
                temp[k] = idx[j];
                rightCount++;
                j++;
            } else {
                temp[k] = idx[i];
                count[idx[i]] += rightCount;
                i++;
            }
            k++;
        }
        
        while(i <= m - 1) {
            temp[k++] = idx[i];
            count[idx[i]] += rightCount;
            i++;
        }
        while(j <= r) temp[k++] = idx[j++];
        
        for(i = l; i <= r; i++) idx[i] = temp[i];
        
    }
}