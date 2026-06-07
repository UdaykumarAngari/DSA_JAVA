class Solution {
    public boolean isPrime(int n){
         
        for(int i = 2 ; i*i <=n; i++){
            if(n%i==0) return false;
        }
        return true;
    }

    public int countPrimes(int n) {
        
        //use steve of eratosthenes
        if(n <= 2) return 0;

        boolean[] prime = new boolean[n];
        Arrays.fill(prime, true);

        prime[0] = false;
        prime[1] = false;

        for(int i = 2; i * i < n; i++) {
            if(prime[i]) {
                for(int j = i * i; j < n; j += i) {
                    prime[j] = false;
                }
            }
        }

        int count = 0;

        for(int i = 2; i < n; i++) {
            if(prime[i]) count++;
        }

        return count;

        //fails for 5000000
        // int count = 0;
        // if(n<=2) return 0;
        // if(n==3) return 1;
        // for(int i = 2 ; i < n ; i++){
        //     if(isPrime(i)) count++;
        // }
        // return count;
    }
}