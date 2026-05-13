class Solution {
    public void merge(int[] nums, int low, int mid, int high ){
        //List<Integer> temp = new ArrayList<>();
        int[] temp = new int[high-low+1];
        int left = low, right = mid+1, k=0;

        while(left <= mid && right <= high){
            if(nums[left]<=nums[right]){
                //temp.add(nums[left++]);
                temp[k++]=nums[left++];
            }
            else{
                //temp.add(nums[right++]);
                temp[k++]=nums[right++];
            }
        }
        while(left<=mid){
            //temp.add(nums[left++]);
            temp[k++]=nums[left++];
        }

        while(right<=high){
            //temp.add(nums[right++]);
            temp[k++]=nums[right++];
        }

        // for(int i = low ; i <= high ;i++ ){
        //     nums[i]=temp.get(i-low);
        // }

        for(int i = low; i <= high; i++){
            nums[i] = temp[i - low];
        }
    }

    public int countPairs(int[] nums, int low, int mid, int high){
        int cnt = 0;
        int right = mid +1;
        for(int i = low ; i < mid +1 ; i++){
            while(right<=high && nums[i] > 2L*nums[right]) right++;
            cnt = cnt + (right-(mid+1));
        }
        return cnt;
    }
    public int mergeSort(int[] nums, int low, int high){
        int cnt = 0;
        if(low>=high){
            return cnt;
        } 
        
        int mid = (low + high)/2;

        cnt += mergeSort(nums, low, mid);

        cnt += mergeSort(nums, mid+1, high);

        cnt += countPairs(nums, low, mid, high);

        merge(nums, low, mid, high);

        return cnt;
    }
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0 , nums.length-1);
        
    }
}