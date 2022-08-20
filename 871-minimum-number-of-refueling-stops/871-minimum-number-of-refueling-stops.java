class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if(startFuel >= target) return 0;
        int count = 0, fuel = startFuel, last = 0;
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        int i = 0;
        while(fuel < target) {
            while(i < stations.length && stations[i][0] <= fuel) heap.offer(stations[i++][1]);
            if(heap.isEmpty()) return -1;
            fuel += heap.poll();
            count++;
        }
        
        return count;
    }
}