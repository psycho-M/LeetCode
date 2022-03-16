class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        while(j < popped.length) {
            if(i == pushed.length) break;
            while(i < pushed.length) {
                stack.push(pushed[i]);
                i++;
                if(popped[j] == pushed[i - 1]) break;
            }
            while(j < popped.length && !stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}