class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        int count = 0;
        for(int[] n : properties) {
            if(stack.isEmpty()) stack.push(n);
            else {
                int[] top = stack.peek();
                while(!stack.isEmpty() && top[0] < n[0] && top[1] < n[1]) {
                    count++;
                    stack.pop();
                    top = stack.peek();
                }
                stack.push(n);
            }
        }
        // System.out.println(stack.peek()[0]);
        return count;
    }
}

// class Solution {
//     public int numberOfWeakCharacters(int[][] nums) {
//         Arrays.sort(nums,(a,b)-> a[0]!=b[0] ? a[0]-b[0] : b[1]-a[1]);
//         Stack<int[]> stack=new Stack<>();
//         int count=0;
//         for(int i=0;i<nums.length;i++){
//             if(stack.isEmpty()){
//                 stack.push(nums[i]);
//             }else{
                
//                 while(!stack.isEmpty() && nums[i][0]>stack.peek()[0] && nums[i][1]>stack.peek()[1]){
//                     count+=1;
//                     stack.pop();
//                 }
//                 stack.push(nums[i]);
//             }
//         }
//         return count;
//     }
// }