class Solution {
    public long calculateHours(int[] piles, int k){
        long sum = 0;

        for(long pile : piles){
            //sum+=Math.ceil((double)pile / k);
            sum += (pile + k - 1) / k;
        }
        return sum;
    }

    public int minEatingSpeed(int[] piles, int h) {
        long sum = 0;
        //int max = Arrays.stream(piles).max().getAsInt();
        int max = piles[0];

        for(int pile : piles){
            sum += pile;
            max = Math.max(max, pile);
        }
        int ans = max;


        //brute force TLE at 108th test case lets try bs from 1 to max(piles)
        // for(int i = 1 ; i <= max ; i++){
        //     ans = Math.min(ans,calculateHours(piles, i));
        //     if(ans<=h) return i;
        // }


        int left =  (int)((sum + h - 1) / h), right = max , mid;

        while(left <= right){

            mid = left + (right-left) / 2;

            long hours = calculateHours(piles, mid);

            if(hours <= h) {
                //ans = mid;
                right = mid - 1;
            }

            else {
                left = mid + 1;
            }

        
        }
        //return ans;
        return left;
    }
    
}