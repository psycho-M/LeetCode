class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // if(nums.length == k) return nums;
        // int count;
        // Map<Integer, Integer> map = new HashMap<>();
        // for(int i = 0; i < nums.length - 1; i++) {
        //     map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        // }
        // Set<Integer> keySet = map.keySet();
        // List<Integer> list = new ArrayList<>(keySet.size());
        // for(int key : keySet) {
        //     if(map.get(key) >= k) list.add(key);
        // }
        // int[] res = new int[list.size()];
        // int i = 0;
        // for(int n : list) res[i++] = n; 
        // return res;
        
//         if (k == nums.length) return nums;
        
//         Map<Integer, Integer> map = new HashMap();
//         for (int n: nums) {
//             map.put(n, map.getOrDefault(n, 0) + 1);
//         }

//         PriorityQueue<Integer> minHeap = new PriorityQueue<>(
//             (key1, key2) -> map.get(key1) - map.get(key2));

//         for (int n : map.keySet()) {
//             minHeap.add(n);
//             if (minHeap.size() > k) minHeap.poll();    
//         }

//         int[] res = new int[k];
//         int i = 0;
//         for(int n : minHeap) res[i++] = n;
//         return res;
        return helper(nums, k);
    }
    
    public int[] helper(int[] nums, int k) {
        if(k == nums.length) return nums;
        Map<Integer, Integer> map = new HashMap();
        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        List<Integer>[] bucket = new List[nums.length + 1];
        
        for(int n : map.keySet()) {
            int freq = map.get(n);
            if(bucket[freq] == null) bucket[freq] = new ArrayList<>();
            bucket[freq].add(n);
        }
        
        int[] res = new int[k];
        k -= 1;
        for(int i = nums.length; i >= 0 && k >= 0; i--) {
            if(bucket[i] != null) {
                // System.out.println(bucket[i]);
                int j = 0;
                for(j = 0; j < bucket[i].size() && k >= 0; j++)  {
                    res[k--] = bucket[i].get(j);
                }
            }
        }
        return res;
    }
}