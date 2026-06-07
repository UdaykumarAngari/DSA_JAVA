class Solution {
    public int singleNumber(int[] nums) {

        int ans = 0;

        for(int bit = 0; bit < 32; bit++) {

            int count = 0;

            for(int num : nums) {

                if((num & (1 << bit)) != 0) {
                    count++;
                }
            }

            if(count % 3 != 0) {
                ans |= (1 << bit);
            }
        }

        return ans;
    }
}