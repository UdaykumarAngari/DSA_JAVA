class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;


        int low = 0;
        int high = nums.length - 1;

        while(low < high){

            int mid = (low + high) / 2;

            // make mid even
            if(mid % 2 == 1){
                mid--;
            }

            if(nums[mid] == nums[mid + 1]){
                low = mid + 2;
            }
            else{
                high = mid;
            }
        }

        return nums[low];

        // if(n==1) return nums[0];

        // if(nums[0]!=nums[1]) return nums[0];

        // if(nums[n-1]!=nums[n-2]) return nums[n-1];
        // int low = 1 , high = n - 2, mid;

        // while(low<=high){
        //     mid = (low + high)/2;

        //     if(mid%2==1){
        //         mid--;
        //     }

        //     if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1] ){
        //         return nums[mid];
        //     }
 
        //     else if(nums[mid]==nums[mid+1]){
        //         if(mid%2==0) {
        //             low = mid+1;
        //         }
        //         else{
        //             high = mid-1;
        //         }
        //     }
        //     else{
        //         if(mid%2==0) {
        //             high = mid-1;
        //         }
        //         else{
        //             low = mid+1;
        //         }
        //     }
        // }

        // return nums[low];


        // int i ;
        // for(i= 0; i < n-1; i++){
        //     if(nums[i]!=nums[i+1]) return nums[i];
        //     else i++;
        // }
        // return nums[i];
    }
}