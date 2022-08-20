class Solution {
    public int trap(int[] height) {
//         ArrayDeque<int[]> stack = new ArrayDeque<>();
//         int curr = 0, max = 0;
//         stack.push(new int[]{0, height[0]});
//         for(int i = 1; i < height.length; i++) {
//             int h = height[i];

//             if(h < stack.peek()[1]) stack.push(new int[]{i, h});
//             else {
//                 int[] last = null;
//                 while(!stack.isEmpty() && h >= stack.peek()[1]) {
//                     int[] top = stack.pop();
//                     curr += (top[1] - (last == null ? 0 : last[1])) * (i - top[0] - 1);
//                     last = top;
//                 }
//                 if(!stack.isEmpty())
//                     curr += (h - (last == null ? 0 : last[1])) * (i - stack.peek()[0] - 1);
//                 stack.push(new int[]{i, h});
//             }
//         }
        
//         return curr;
        
        int l = 0, r = height.length - 1;
        int minH = 0;
        int total = 0;
        while(l < r) {
            if(height[l] <= height[r]) {
                if(minH > height[l]) total += minH - height[l];
                else minH = height[l];
                l++;
            } else {
                if(minH > height[r]) total += minH - height[r];
                else minH = height[r];
                r--;
            }
        }
        
        return total;
    }
}