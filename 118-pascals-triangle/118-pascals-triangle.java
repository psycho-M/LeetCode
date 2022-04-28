class Solution {
    
    /*
        A simulation problem.
        
        What we do is, for every row (except the first one), we add 1 at the start and end of that row, in this case list.
        To get the jth element of ith row, we add the (j - 1)th and jth element of the row/list before current list, 
        i.e. (i - i)th row.
        
        ex: 7th element of the 9th row will be the summ of 6th and 7th element of the 8th row.
    */
    
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