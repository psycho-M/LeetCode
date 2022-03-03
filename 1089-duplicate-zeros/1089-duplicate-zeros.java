class Solution {
    public void duplicateZeros(int[] arr) {
        if(arr.length == 1) return;
        Queue<Integer> q = new LinkedList<>();
        int i;
        for(i = 0; i < arr.length - 1; i++) {
            if(!q.isEmpty()) {
                q.offer(arr[i]);
                arr[i] = q.poll();
            }
            if(arr[i] == 0) {
                q.offer(arr[i + 1]);
                arr[i + 1] = 0;
                i++;
            }
        }
        if(!q.isEmpty() && i == arr.length - 1) arr[i] = q.poll();
        // arr[arr.length - 1] = !q.isEmpty() ? q.poll() : arr[arr.length - 1];
    }
}