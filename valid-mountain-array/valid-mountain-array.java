class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3) return false;
        int i = 0;
        while(i < arr.length - 1 && arr[i] < arr[i + 1]) i++;
        // System.out.println(i);
        if(i == 0 || i == arr.length - 1 || arr[i] <= arr[i + 1]) return false;
        while(i < arr.length - 1 && arr[i] > arr[i + 1]) i++;
        // System.out.println(i);
        if(i < arr.length - 1) return false;
        return true;
    }
}