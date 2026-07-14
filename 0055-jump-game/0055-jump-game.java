class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {

            // Cannot even reach index i
            if (i > maxReach) {
                return false;
            }

            // Farthest position reachable from here
            maxReach = Math.max(maxReach, i + nums[i]);

            // Last index is reachable
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }
}