class Solution {
    public int[] countBits(int n) {
        int ans[] = new int[n + 1];
        ans[0] = 0;
        // int temp, count;
        for(int i = 1; i <= n; i++) {
            // temp = i;
            // count = 0;
            // while(temp > 0) {
            //     count += temp % 2 == 0 ? 0 : 1;
            //     temp = temp>>1;
            // }
            ans[i] = ans[i >> 1] + (i & 1);
        }
        
        return ans;
    }
}