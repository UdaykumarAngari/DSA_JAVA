class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;

        // xor of all numbers
        for(int num : nums){
            xor ^= num;
        }

        // get rightmost set bit
        int rightMostSetBit = xor & (-xor);

        int a = 0;
        int b = 0;

        // divide into 2 groups
        for(int num : nums){

            if((num & rightMostSetBit) != 0){
                a ^= num;
            }
            else{
                b ^= num;
            }
        }

        return new int[]{a, b};
        
        // ArrayList<Integer> list = new ArrayList<>();

        // HashMap<Integer, Integer> map = new HashMap<>();

        // for(int num : nums){
        //     map.put(num, map.getOrDefault(num, 0)+1);
        // }

        // for(Map.Entry<Integer, Integer> entry : map.entrySet()){
        //     if(entry.getValue() == 1){
        //         list.add(entry.getKey());
        //     }
        // }
        // int[] ans = new int[2];

        // for(int i = 0; i < list.size(); i++){
        //     ans[i] = list.get(i);
        // }

        // return ans;
    }
}