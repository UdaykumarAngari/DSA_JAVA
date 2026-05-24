class Solution {
    public boolean isPossible(int[] bloomDays, int day, int m, int k){
        int count = 0;
        int boquets = 0;

        for(int bloomDay : bloomDays){
            if(bloomDay <= day){
                count++;
                if(count == k){
                    boquets++;
                    count = 0;
                }
            }
            else {
                count = 0;
            }
        }
        return boquets >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        
        //if total flowers required greater than we have not possible to make boquet
        if(((long)m * k) > n) return -1;

        // int min = Arrays.stream(bloomDay).min().getAsInt();
        // int max = Arrays.stream(bloomDay).max().getAsInt();


        //changed beats from 11.5 to 96.75% always use arrays
        int min=Integer.MAX_VALUE , max = Integer.MIN_VALUE ;
        for( int day : bloomDay ){
            if( min > day ) min = day;
            if( max < day ) max = day;
        }


        //instead of searching everyday ,lets do binary search
        // for(int day = min ; day <= max ;day++ ){
        //     if(isPossible(bloomDay, day, m, k)){
        //         return day;
        //     }
        // }

        int left = min, right = max , mid;

        while(left <= right){
            mid = (left + right) / 2;

            if(isPossible(bloomDay, mid, m, k)){
                right = mid - 1;
            }

            else{
                left = mid + 1;
            }
        }

        return left;
    }
}