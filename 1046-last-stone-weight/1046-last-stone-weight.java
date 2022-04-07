class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1) return stones[0];
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int n : stones) heap.add(n);
        int y, x;
        while(heap.size() > 1) {
            y = heap.poll();
            x = heap.poll();
            if(x != y) {
                heap.add(y - x);
            }
        }
        return heap.size() == 0 ? 0 : heap.poll();
    }
}