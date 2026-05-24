class Solution {

    public int divSum(int[] nums, int div){

        int sum = 0;

        for(int num : nums){

            sum += (num + div - 1) / div;
        }

        return sum;
    }

    public int smallestDivisor(int[] nums, int threshold) {

        //int max = Arrays.stream(nums).max().getAsInt();
        
        int max = nums[0];
        for(int num : nums){
            if(max < num) max = num;
        }

        //got tle for this using binary search on answers
        // for(int div = 1; div <= max; div++){

        //     if(divSum(nums, div) <= threshold){
        //         return div;
        //     }
        // }

        int left = 1, right = max ;
        while(left <=  right){
            int mid = (left + right) / 2;

            if(divSum(nums, mid) <= threshold){
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return left;
    }
}