class Solution {
    public boolean checkIfExist(int[] arr) {
        int len = arr.length;
        Set<Float> set = new HashSet<>();
        int i = 0;
        for(float n : arr) {
            if(n == 0) {
                if(set.contains(n)) return true;
                else set.add(n);
                continue;
            }
            set.add(n);
            // System.out.println("n / 2: " + n / 2 + " n * 2: " + (n * 2));
            if(set.contains(n / 2) || set.contains(n * 2)) return true;
        }
        // if(set.contains(arr[len - 1] / 2) || set.contains(arr[len - 1] * 2)) return true;
        
        return false;
    }
}