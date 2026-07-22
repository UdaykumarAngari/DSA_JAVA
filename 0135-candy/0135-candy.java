class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        int cnt = 0 ;

        Arrays.fill(candies, 1);


        //left to right
        for(int i = 1 ; i  < n ; i++){
            if(ratings[i] > ratings[i-1]){
                candies[i] = candies[i-1] + 1;
            }
        }

        //right to left check
        for(int i = n - 1 ; i > 0 ; i--){
            if(ratings[i-1] > ratings[i]){
                candies[i-1] = Math.max(candies[i]+1, candies[i-1]);   
            }
            cnt+=candies[i-1];

        }
        return cnt+ candies[n-1];


    }
}