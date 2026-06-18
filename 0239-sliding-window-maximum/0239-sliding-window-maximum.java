class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        int[] ans = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        int ind = 0;
        for(int i =0 ; i < n ;i++){

            //reomving the indexes which are not in current window
            while(!dq.isEmpty() && dq.peekFirst() <= (i - k)){
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }

            dq.offerLast(i);

            if(i >= k - 1){
                ans[ind++] = nums[dq.peekFirst()];
            }

        }

        return ans;
        //brute force tle
        // ArrayList<Integer> list = new ArrayList<>();

        // for(int i = 0 ;  i < n - k + 1 ; i++  ){
        //     int max = nums[i];
        //     for(int j = i ;  j<i + k  ; j++){
        //         max = Math.max(max, nums[j]);
        //     }
        //     list.add(max);
        // }
        // int x = list.size();
        // int[] res = new int[x];
        // for(int i = 0 ; i < x; i++){
        //     res[i] = list.get(i);
        // }
        
        // return  res;
    }
}