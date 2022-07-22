class Solution {
    public int openLock(String[] deadends, String target) {
        ArrayDeque<String> q = new ArrayDeque<>();
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        
        if(deads.contains("0000")) return -1;
        
        q.offer("0000");
        
        int step = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                String curr = q.poll();
                if(curr.equals(target)) return step;
                for(int i = 0; i < 4; i++) {
                    int num = (curr.charAt(i) - '0' + 1 + 10) % 10;
                    String temp = curr.substring(0, i) + num + curr.substring(i + 1, 4);
                    if(!deads.contains(temp)) {
                        q.offer(temp);
                        deads.add(temp);
                    }
                    num = (curr.charAt(i) - '0' - 1 + 10) % 10;
                    temp = curr.substring(0, i) + num + curr.substring(i + 1, 4);
                    if(!deads.contains(temp)) {
                        q.offer(temp);
                        deads.add(temp);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}