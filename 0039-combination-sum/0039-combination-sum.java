class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>() ;
        generate(0, target, list, ans, candidates);
        return ans;
    }

    public void generate(int ind,int target, ArrayList<Integer> list, List<List<Integer>> ans,int[] nums){
        if(ind == nums.length){
            if(target == 0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        if(nums[ind] <= target){
            list.add(nums[ind]);
            generate(ind, target - nums[ind], list, ans, nums );
            list.remove(list.size() - 1);
        }

        generate(ind + 1, target, list, ans, nums );
    }
}