class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int n = nums.length;

        List<Integer> res = new ArrayList<>();

        int small = 0, cnt = 0;

        for (int i = 0; i < n; i++) {

            if (nums[i] < target){
                small++;
            }

            if (nums[i] == target){
                cnt++;
            }
        }
        if (cnt == 0) return res;

        for (int i = 1; i <= cnt; i++)
            res.add(small++);
        
        return res;
    }
}