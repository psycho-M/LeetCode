class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : paths) {
            String[] curr = s.split(" ");
            String currDir = curr[0];
            for(int i = 1; i < curr.length; i++) {
                String data = curr[i].substring(curr[i].indexOf('('), curr[i].indexOf(')'));
                if(!map.containsKey(data)) map.put(data, new ArrayList<>());
                map.get(data).add(currDir + "/" + curr[i].substring(0, curr[i].indexOf('(')));
            }
        }
        
        List<List<String>> res = new ArrayList<>(map.size());
        
        for(String s : map.keySet()) {
            if(map.get(s).size() > 1)  {
                res.add(map.get(s));
            }
        }
        
        return res;
    }
}