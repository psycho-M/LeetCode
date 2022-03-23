class Solution {
    public int brokenCalc(int s, int target) {
        if(target == s) return 0;
        if(target < s) return s - target;
        int count = 0;
        while(target > s) {
            target = target % 2 == 0 ? target / 2 : target + 1;
            count++;
        }
        
        return count + (s - target);
        // int count = 0, half = target / 2;
        // System.out.println(half);
        // while(s != target) {
        //     if(s == half) return ++count;
        //     else if(s < half) {
        //         s *= 2;
        //         count++;
        //         System.out.println(s);
        //     } else {
        //         while(s != half) {
        //             s--;
        //             count++;
        //         }
        //         s *= 2;
        //         count++;
        //         return count;
        //     }
        // }
        // return count;
    }
}