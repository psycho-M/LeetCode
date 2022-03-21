class Solution {
    public List<Integer> partitionLabels(String s) {
        int len = s.length();
        if(len == 1) {
            List<Integer> res = new ArrayList<>(1);
            res.add(1);
            return res;
        }
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        
        List<Integer> res = new LinkedList<>();
        
        for(i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c))
                map.put(c, s.lastIndexOf(String.valueOf(c)));
        }
        i = 0;
        while(i < len) {
            char c = s.charAt(i);
            int last = map.get(c);
            for(int k = i + 1; k <= last; k++) {
                char ch = s.charAt(k);
                if(map.get(ch) > last) last = map.get(ch);
            }
            // System.out.println(map);
            res.add(last - i + 1);
            i = last + 1;
            
        }
        
        return res;
    }
}