class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] prefMax = new int[n];
        int[] suffMax = new int[n];

        prefMax[0] =  height[0];
        for(int i = 1 ; i < n ; i++ ){
            prefMax[i] = Math.max(prefMax[i-1], height[i]);
        }

        suffMax[n-1] =  height[n-1];
        for(int i = n-2; i >= 0  ; i-- ){
            suffMax[i] = Math.max(suffMax[i+1], height[i]);
        }

        int total = 0;
        for(int i = 0 ; i < n ; i++){
            int left = prefMax[i];
            int right = suffMax[i];
            if(height[i] <= left && right >= height[i]  ){
                total+= Math.min(left, right) - height[i];
            }
        }
        return total;
    }
}