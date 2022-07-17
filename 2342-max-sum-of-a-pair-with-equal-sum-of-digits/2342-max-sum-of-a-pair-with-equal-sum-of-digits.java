class Solution {
    public int maximumSum(int[] nums) {
        int sumI = 0, max = 0;
        
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            sumI = sumOfDigits(nums[i]);
            if(map.containsKey(sumI)) {
                max = Math.max(max, nums[i] + map.get(sumI));
                map.put(sumI, Math.max(nums[i], map.get(sumI)));
            } else {
                map.put(sumI, nums[i]);
            }
        }
        
        return max == 0 ? -1 : max;
    }
    
    public int sumOfDigits(int n) {
        int sum = 0;
        while(n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}