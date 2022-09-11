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
}