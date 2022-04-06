class Solution {
    public int threeSumMulti(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = arr.length;
        
        int count = 0;
        for(int i = 0; i < len; i++) {
            count = (count + map.getOrDefault(target - arr[i], 0)) % 1000000007;
            
            for(int j = 0; j < i; j++) {
                int temp = arr[i] + arr[j];
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }
        
        return count;
        
        
        
        
        //Brute force
        // int count = 0;
        // for(int i = 0; i < arr.length - 2; i++) {
        //     for(int j = i + 1; j < arr.length - 1; j++) {
        //         for(int k = j + 1; k < arr.length; k++) {
        //             if(arr[i] + arr[k] + arr[j] == target) {
        //                 count++;
        //             }
        //         }
        //     }
        // }
        // return count % (1000000007);
    }
}