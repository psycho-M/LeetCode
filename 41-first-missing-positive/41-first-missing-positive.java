class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums) set.add(n);
        int i = 1;
        for(i = 1; ; i++) {
            if(!set.contains(i)) return i;
        }
    }
}