class Solution {
    public int[] findOriginalArray(int[] changed) {
        int len = changed.length;
        if(len % 2 != 0) return new int[]{};
        Arrays.sort(changed);
        
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int n : changed) {
            // System.out.println(map);
            int curr = n / 2;
            if(n % 2 == 0 && map.containsKey(curr)) {
                if(map.get(curr) == 1) map.remove(curr);
                else map.put(curr, map.get(curr) - 1);
                list.add(curr);
            } else map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        if(map.isEmpty()) {
            int[] res = new int[list.size()];
            int i = 0;
            for(int n : list) res[i++] = n;
            return res;
        } else return new int[]{};
    }
}