class Solution {
    public int minDeletions(String s) {
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        int n = ch.length, count = 0, freq = 1;
        int[] arr = new int[n + 1];
        for(int i = 0; i < n - 1; i++) {
            if(ch[i] == ch[i + 1]) freq++;
            else {
                if(arr[freq] == 0) arr[freq] = 1;
                else {
                    while(freq > 0 && arr[freq] == 1) {
                        freq--;
                        count++;
                    }
                    if(freq > 0) arr[freq] = 1;
                }
                freq = 1;
            }
        }
        while(freq > 0 && arr[freq] == 1) {
            freq--;
            count++;
        }
        if(freq > 0) arr[freq] = 1;
        return count;
    }
}