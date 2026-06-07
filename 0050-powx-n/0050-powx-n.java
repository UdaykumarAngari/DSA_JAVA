class Solution {

    public double pow(double x, long N, double ans){
        if(N==0) return ans;
        if(N % 2 ==1 ){
            ans*=x;
        }
        return pow(x*x, N/2, ans);
    }
    public double myPow(double x, int n) {
        // double ans = 1;
         long N = n;

        if(N < 0){
            x = 1 / x;
            N = -N;
        }

        double result = 1;
        
        while (N > 0){

        
            //# If the lowest bit is set (n is odd)
            if ((N & 1 )!= 0)result *= x;
                
            x *= x;    
            N >>= 1 ;          
        }
        return result;

        // while(N > 0){

        //     if(N % 2 == 1){
        //         ans *= x;
        //     }

        //     x *= x;

        //     N /= 2;
        // }
        // return  ans ;

        //return pow(x, N, 1);
    }
}