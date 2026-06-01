class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>() ;
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        generate(0, k, n, list, ans, nums);
        return ans;
    }

    public void generate(int ind,int k , int target, ArrayList<Integer> list, List<List<Integer>> ans,int[] nums){
        if(ind == nums.length){
            if(k==0 && target == 0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        if(nums[ind] <= target){
            list.add(nums[ind]);
            generate(ind+1, k - 1, target - nums[ind], list, ans, nums );
            list.remove(list.size() - 1);
        }

        generate(ind + 1, k , target, list, ans, nums );
    }
}