class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int left = 0, right = nums.length-1, mid;

        if(n==1) return 0;
        if(nums[0]>nums[1]) return 0;
        if(nums[n-1]>nums[n-2]) return n-1;

        while(left<right){

            mid = (left+right)/2;

            if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1]) return mid;
            if(nums[mid]>nums[mid+1]) right = mid;
            else{
                left = mid +1;
            }
        }
        return left;
    }
}