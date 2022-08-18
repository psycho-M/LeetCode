class Solution {
    public int minSetSize(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : arr) map.put(a, map.getOrDefault(a, 0) + 1);
        PriorityQueue<Integer> keyDesc = new PriorityQueue<>((a, b) -> b - a);
        for(int value : map.values()) keyDesc.add(value);
        int count = 0, removed = 0;
        
        while(removed < n / 2) {
            removed += keyDesc.poll();
            count++;
        }
        
        return count;
    }
}