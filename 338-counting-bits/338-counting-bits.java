class Solution {
    public int[] countBits(int n) {
        /*
            two methods
            method 1: brute force
                we calculate no. of ones for every number by checking if the number is even.
                if odd
                    add 1 to count
                else don't add
                the logic works on the fact that the least significant digit (lsd) of an
                even number is zero, so we don't add one, else we do add.
            
            method 2: building on the above logic, more efficient
                 the number of ones in an even number is the same as the number of ones in
                 the num/2. We use this to look-up the num/2 value from the past values.
                 If the number is add, we do an & operation on num to add 1 to the previous
                 value.
                 f[num] = f[num >> 1] + (num & 1);
            
                    
        */
        int ans[] = new int[n + 1];
        ans[0] = 0;
        // int temp, count;
        for(int i = 1; i <= n; i++) {
            //brute force
            // temp = i;
            // count = 0;
            // while(temp > 0) {
            //     count += temp % 2 == 0 ? 0 : 1;
            //     temp = temp>>1;
            // }
            
            //efficient, using previous values
            ans[i] = ans[i >> 1] + (i & 1);
        }
        
        return ans;
    }
}