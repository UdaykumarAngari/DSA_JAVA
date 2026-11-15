class Solution {
    public int numOfSubarrays(int[] arr) {
        int n=arr.length;

        int Mod=1000000007;
        int oddCount=0;

        int evenCount=1;
        int count=0;
        
        int prefixSum=0;

        for(int i=0;i<n;i++){    
            prefixSum+=arr[i];
             if((prefixSum & 1)==0) {
                count+=oddCount;
                evenCount++;
             }
             else{
                count+=evenCount;
                oddCount++;
             }  
             count%=Mod;
        }
        return count;
    }
}