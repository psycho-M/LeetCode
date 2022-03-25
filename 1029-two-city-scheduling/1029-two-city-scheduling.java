class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int cost = 0;
        int[] refund = new int[costs.length];
        for(int i = 0; i < costs.length; i++) {
            cost += costs[i][0];
            refund[i] = costs[i][1] - costs[i][0];
        }
        Arrays.sort(refund);
        for(int i = 0; i < costs.length / 2; i++) {
            cost += refund[i];
        }
        return cost;
    }
}