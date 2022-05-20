class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1) return intervals;
        List<int[]> list = new LinkedList<>();
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        int[] curr = intervals[0];
        int i = 0;
        while(i < intervals.length - 1) {
            if(curr[1] >= intervals[i + 1][0]) {
                if(curr[1] < intervals[i + 1][1]) curr[1] = intervals[++i][1];
                else i++;
            }
            else {
                list.add(curr);
                curr = intervals[++i];
            }
        }
        list.add(curr);
        
        int[][] res = new int[list.size()][2];
        i = 0;
        for(int[] n : list) res[i++] = n;
        return res;
    }
}