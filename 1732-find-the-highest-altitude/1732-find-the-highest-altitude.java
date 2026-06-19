class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int sum = 0;
        for(int num : gain){
            sum+=num;
            max = Math.max(max, sum);
        }
        return max;
    }
}