class Solution {
    public int countPartitions(int[] nums, int maxSum){
        int n = nums.length;
        
        int partitions = 1;

        long sum = 0;

        for(int i = 0 ; i < n ; i++){
            if(sum + nums[i] <= maxSum){
                sum += nums[i];
            }
            else{
                partitions++;

                sum = nums[i];
            }
        }
        return partitions;
    }
    public int splitArray(int[] nums, int k) {

        int low = 0, high = 0;

        for(int num : nums){

            low = Math.max(num, low);

            high += num;
        }

        // for(int i = low ; i <= high ; i++){
        //     if(countPartitions(nums, i) <= k){
        //         return i;
        //     }
        // }

        while(low <= high){

            int mid = (low + high) / 2;

            if(countPartitions(nums,mid)<=k){

                high = mid - 1;

            }
            else {

                low = mid + 1;

            }
        }

        return low;

    }
}