class Solution {
    public int minSetSize(int[] arr) {
        int n = arr.length;
//         Map<Integer, Integer> map = new HashMap<>();
//         for(int a : arr) map.put(a, map.getOrDefault(a, 0) + 1);
//         PriorityQueue<Integer> keyDesc = new PriorityQueue<>((a, b) -> b - a);
//         for(int value : map.values()) keyDesc.add(value);
//         int count = 0, removed = 0;
        
//         while(removed < n / 2) {
//             removed += keyDesc.poll();
//             count++;
//         }
        
//         return count;
        
        int max = 0;
        for(int a : arr) max = Math.max(max, a);
        int[] freq = new int[max + 1];
        for(int a : arr) freq[a]++;
        max = 0;
        for(int f : freq) max = Math.max(max, f);
        int[] freqCount = new int[max + 1];
        for(int f : freq) freqCount[f]++;
        
        int removed = 0, count = 0;
        
        for(int i = max; i > 0; i--) {
            while(freqCount[i] > 0) {
                removed += i;
                freqCount[i]--;
                count++;
                if(removed >= n / 2) return count;                
            }
        }
        
        return count;
    }
}