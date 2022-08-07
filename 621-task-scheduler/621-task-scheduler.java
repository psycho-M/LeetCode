class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(n == 0) return tasks.length;
        Map<Character, Integer> freq = new HashMap<>();
        for(char c : tasks) freq.put(c, freq.getOrDefault(c, 0) + 1);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(char c : freq.keySet()) pq.offer(freq.get(c));
        int max = pq.poll() - 1;
        int spaces = max * n;
        while(!pq.isEmpty()) {
            spaces -= Math.min(max, pq.poll());
        }
        spaces = Math.max(0, spaces);
        return tasks.length + spaces;
    }
}