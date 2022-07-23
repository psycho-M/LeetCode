class Solution {
    public List<Integer> countSmaller(int[] nums) {
        // List<Integer> count = new ArrayList<>(nums.length + 1);
        
        int[] idx = new int[nums.length], temp = new int[nums.length], count = new int[nums.length];
        
        Arrays.fill(count, 0);
        
        for(int i = 0; i < nums.length; i++) idx[i] = i;
        
        mergeSort(idx, 0, nums.length - 1, nums, temp, count);
        
        // for(int[] i : freq) count.add(i[]);
        return Arrays.stream(count).boxed().collect(Collectors.toList());
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