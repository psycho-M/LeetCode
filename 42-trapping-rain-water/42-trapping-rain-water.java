class Solution {
    public int trap(int[] height) {
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        int curr = 0, max = 0;
        
        for(int i = 0; i < height.length; i++) {
            int h = height[i];
            if(stack.isEmpty()) {
                stack.push(new int[]{i, h});
            } else {
                if(h < stack.peek()[1]) stack.push(new int[]{i, h});
                else {
                    int[] last = null;
                    while(!stack.isEmpty() && h >= stack.peek()[1]) {
                        // print(stack);
                        int[] top = stack.pop();
                        curr += (top[1] - (last == null ? 0 : last[1])) * (i - top[0] - 1);
                        last = top;
                        // System.out.println(last[1]);
                    }
                    if(!stack.isEmpty())
                        curr += (h - (last == null ? 0 : last[1])) * (i - stack.peek()[0] - 1);
                    // System.out.println(curr);
                    stack.push(new int[]{i, h});
                    // print(stack);
                }
            }
        }
        
        return curr;
    }
    
    void print(ArrayDeque<int[]> stack) {
        System.out.print("[");
        for(int[] n : stack) {
            System.out.print(n[1] +", ");
        }
        System.out.println("]");
    }
}