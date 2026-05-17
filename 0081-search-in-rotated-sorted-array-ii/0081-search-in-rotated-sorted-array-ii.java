class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;

        int low = 0 , high = n-1, mid;

        while(low <= high){

            mid = (low + high) / 2;
            if(nums[mid] == target) return true;

            else if((nums[low]==nums[mid]) && (nums[high]==nums[mid])){
                low++;
                high--;
            }
            //left sorted
            else if(nums[low] <= nums[mid]){
                if((target >= nums[low]) && (target < nums[mid])){
                    high = mid - 1;
                }
                else{
                    low = mid + 1 ;
                }
            }
            
            //right sorted
            else{
                if((target > nums[mid]) && (target <= nums[high])){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }

        // for(int i = 0 ; i < n ; i++){
        //     if(nums[i] == target) return true;
        // }
        return false;
    }
}