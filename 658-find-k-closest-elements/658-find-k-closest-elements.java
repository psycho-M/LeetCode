class Solution {
    
    public int binarySearch(int[] arr, int target) {
        int l = 0, r = arr.length - 1, m = 0;
        
        while(l < r) {
            m = (l + r) / 2;
            if(arr[m] == target) return m;
            else if(arr[m] < target) l = m + 1;
            else r = m - 1;
        }
        
        return -1;
    }
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>(k);
        int len = arr.length;
        if(x > arr[len - 1]) {
            for(int i = len - k; i < len; i++) res.add(arr[i]);
            return res;
        } else if(x < arr[0]) {
            for(int i = 0; i < k; i++) res.add(arr[i]);
            return res;
        }
        
//         int idx = binarySearch(arr, x);
        
//         int l = idx, r = idx + 1, max = Math.max(x - arr[0], arr[len - 1] - x);
        
//         while(k-- > 0) {
//             int left = l >= 0 ? Math.abs(arr[l] - x) : max + 1;
//             int right = r < arr.length ? Math.abs(arr[r] - x) : max + 1;
            
//             if(left == right) {
//                 res.add(arr[l]);
//                 l--;
//             } else if(left < right) {
//                 res.add(arr[l]);
//                 l--;
//             } else {
//                 res.add(arr[r]);
//                 r++;
//             }
//         }
        
//         Collections.sort(res);
//         return res;
        
//         Map<Integer, Integer> map = new HashMap<>();
//         PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        
//         for(int n : arr) {
//             int toAdd = n >= x ? n - x : x - n; 
//             map.put(n, toAdd);
//             pq.offer(n);
//         }
        
//         System.out.println(map);
//         System.out.println(pq);
        
//         while(k-- > 0) res.add(pq.poll());
        
//         TreeMap<Integer, Integer> tMap = new TreeMap<>();
        
//         for(int n : arr) tMap.put(n, Math.abs(x - n));
        
//         for(int key : tMap.keySet()) {
//             if(k-- > 0) res.add(key);
//             else break;
//         }
        
//         Collections.sort(res);
        
        int l = 0;
		int h = arr.length - 1;
		while (h - l >= k) {
			if (Math.abs(arr[l] - x) > Math.abs(arr[h] - x)) l++;
            else h--;
		}
        
		for (int i = l; i <= h; i++) res.add(arr[i]);
        
        return res;
    }
}