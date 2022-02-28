class Solution {
    /*
        We use the two pointer approach in this problem.
        We keep one pointer at the start(l) of array and one at the end(r).
        
        We compare the heights at the rth and lth index and find the index with the lower height.
        Once the lower height is found, we calculate the area of water contained
        using the recatngle area formula with one side as difference between the r and l nodes,
        and the other as the lower height.
        If the lth node is lower height, we increment the lth index, else we decrement
        the rth index.
        
        We keep doing this until the lth index is lower than the rth index.
    */
    public int maxArea(int[] height) {
        if(height.length == 2) return Math.min(height[0], height[1]);
        
        int l = 0, r = height.length - 1, max = 0;
        
        while(l < r) {
            int curr = 0;
            if(height[l] <= height[r]) {
                curr = (r - l) * height[l++];
            } else {
                curr = (r - l) * height[r--];
                
            }
            
            if(curr > max) max = curr;
        }
        
        return max;
    }
}