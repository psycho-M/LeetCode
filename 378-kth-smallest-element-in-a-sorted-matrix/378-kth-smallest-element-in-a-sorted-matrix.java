class Solution {
    public int kthSmallest(int[][] m, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int i = 0; i < m.length; i++) {
            for(int j = 0; j < m.length; j++) {
                pq.offer(m[i][j]);
                if(pq.size() > k) pq.poll();
            }
        }
        return pq.poll();
    }
}