class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int len = people.length, count = 0, i = 0, j = len - 1, curr;
        while(i <= j) {
            curr = people[i] + people[j];
            if(curr <= limit) {
                i++;
            }
            j--;
            count++;
        }
        // if(i == j) return ++count;
        return count;
    }
}