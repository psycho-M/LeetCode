class Solution {
    
    class Engineer {
        int speed, efficiency;
        public Engineer(int speed, int efficiency) {
            this.speed = speed;
            this.efficiency = efficiency;
        }
        
        public String toString() {
            return "[" + speed + ", " + efficiency + "]";
        }
    }
    
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        Engineer[] engs = new Engineer[speed.length];
        
        for(int i = 0; i < speed.length; i++) engs[i] = new Engineer(speed[i], efficiency[i]);
        
        Arrays.sort(engs, (a, b) -> b.efficiency - a.efficiency);
        
        PriorityQueue<Integer> kHeap = new PriorityQueue<>((a, b) -> a - b);
        long res = 0, speedSum = 0;
        for(Engineer e : engs) {
            kHeap.add(e.speed);
            speedSum += e.speed;
            if(kHeap.size() > k) speedSum -= kHeap.poll();
            res = Math.max(res, (speedSum * e.efficiency));
        }
        
        return (int) (res % 1000000007);
        
    }
    
    // public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
    //     int[][] ess = new int[n][2];
    //     for (int i = 0; i < n; ++i)
    //         ess[i] = new int[] {efficiency[i], speed[i]};
    //     Arrays.sort(ess, (a, b) -> b[0] - a[0]);
    //     PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b);
    //     long res = 0, sumS = 0;
    //     for (int[] es : ess) {
    //         pq.add(es[1]);
    //         sumS = (sumS + es[1]);
    //         if (pq.size() > k) sumS -= pq.poll();
    //         res = Math.max(res, (sumS * es[0]));
    //     }
    //     return (int) (res % (long)(1e9 + 7));
    // }
}