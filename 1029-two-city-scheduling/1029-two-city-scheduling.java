class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int cost = 0;
        int[] refund = new int[costs.length]; //refund bth - ath
        for(int i = 0; i < costs.length; i++) {
            cost += costs[i][0]; //sending all to a
            refund[i] = costs[i][1] - costs[i][0];
        }
        Arrays.sort(refund); //sorting to know whom all to send to b
        for(int i = 0; i < costs.length / 2; i++) {
            cost += refund[i]; // correcting the costs
        }
        return cost;
    }
}