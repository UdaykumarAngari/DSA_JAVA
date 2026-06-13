class Solution {
    public int trap(int[] height) {
        int n = height.length;
        //two pointer approach

        int leftMax = 0;
        int rightMax = 0;
        int total = 0;
        int l = 0;
        int r = n-1;

        while(l<r){
            //checking right side boundary 
            if(height[l] <= height[r]){
                //check if left boundary exists
                if(leftMax >= height[l]){
                    total+= leftMax - height[l];
                }
                else{
                    leftMax = height[l];
                }
                l++;
            }
            else{
                //checking the smaller right side element
                if(rightMax > height[r]){
                    total += rightMax - height[r];
                }
                else {
                    rightMax = height[r];
                }
                r--;
            }
        }
        return total;











        //brute force tc : O(3n) sc : O(2n)
        // int[] prefMax = new int[n];
        // int[] suffMax = new int[n];

        // prefMax[0] =  height[0];
        // for(int i = 1 ; i < n ; i++ ){
        //     prefMax[i] = Math.max(prefMax[i-1], height[i]);
        // }

        // suffMax[n-1] =  height[n-1];
        // for(int i = n-2; i >= 0  ; i-- ){
        //     suffMax[i] = Math.max(suffMax[i+1], height[i]);
        // }

        // int total = 0;
        // for(int i = 0 ; i < n ; i++){
        //     int left = prefMax[i];
        //     int right = suffMax[i];
        //     if(height[i] <= left && right >= height[i]  ){
        //         total+= Math.min(left, right) - height[i];
        //     }
        // }
        // return total;
    }
}