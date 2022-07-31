class Solution {
    public int longestCycle(int[] edges) {
        int[] visited = new int[edges.length];
        int max = -1;
        for(int i = 0; i < edges.length; i++) {
            if(visited[i] == 1) continue;
            
            Map<Integer, Integer> map = new HashMap<>();
            int idx = i, currDist = 0;
            while(idx != -1) {
                if(map.containsKey(idx)) {
                    max = Math.max(max, currDist - map.get(idx));
                    break;
                }
                if(visited[idx] == 1) break;
                visited[idx] = 1;
                map.put(idx, currDist++);
                idx = edges[idx];
            }
        }
        return max;
    }   
}