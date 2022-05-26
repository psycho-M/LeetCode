class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        HashMap<String, Integer> map = new HashMap<>();
        if(len < 10) return new ArrayList();
        int i = 0;
        while(i + 10 <= len) {
            String temp = s.substring(i, i + 10);
//             if(map.containsKey(temp)) {
                
//             } else map.put(temp, map.getOrDefault(temp, 0) + 1);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            i++;
        }
        List<String> res = new ArrayList<>();
        for(String st : map.keySet()) {
            if(map.get(st) > 1) res.add(st);
        }
        return res;
    }
}