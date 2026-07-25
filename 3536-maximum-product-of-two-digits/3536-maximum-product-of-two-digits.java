class Solution {
    public int maxProduct(int n) {
        int max = 0;
        int secMax = 0 ;

        while(n>0){
            int rem = n%10;

            if(rem > max){
                secMax = max;
                max = rem;
            }else if(rem > secMax){
                secMax = rem;
            }
            n/=10;
        }
        return max*secMax;
    }
}