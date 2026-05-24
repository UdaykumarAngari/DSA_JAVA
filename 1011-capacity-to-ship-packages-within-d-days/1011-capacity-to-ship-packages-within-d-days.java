class Solution {

    public int countDays(int[] weights, int cap){

        int days = 1;

        int sum = 0;

        for(int w : weights){

            // if sum exceeds the capacity
            if(sum + w > cap){

                days++;

                sum = w;
            }
            else{
                sum += w;
            }
        }

        return days;
    }

    public int shipWithinDays(int[] weights, int days) {

        int maxWeight = 0;

        int totalWeight = 0;

        for(int w : weights){

            maxWeight = Math.max(maxWeight, w);

            totalWeight += w;
        }

        //got tle lets do bs in the range of maxweight and total weight
        // for(int cap = maxWeight; cap <= totalWeight; cap++){

        //     if(countDays(weights, cap) <= days){

        //         return cap;
        //     }
        // }
        int low = maxWeight, high = totalWeight;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(countDays(weights, mid) <= days){
                high = mid -1;
            }
            else {
                low = mid + 1;
            }
        }
        //return -1;

        return low;
    }
}