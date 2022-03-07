class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>(), curr;
        temp.add(1);
        res.add(temp);
        
        if(numRows == 1) {
            return res;
        }
        
        for(int i = 1; i < numRows; i++) {
            
            curr = new ArrayList<>();
            curr.add(1);
            
            temp = res.get(i - 1);
            
            for(int j = 1; j < i; j++) {
                int ele = temp.get(j - 1) + temp.get(j);
                curr.add(ele);
            }
            
            curr.add(1);
            
            res.add(curr);
        }
        
        return res;
    }
}