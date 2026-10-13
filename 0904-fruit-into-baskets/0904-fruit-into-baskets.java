class Solution {
    public int totalFruit(int[] fruits) {
        int start = 0,end = 0;

        int n = fruits.length, maxLen = 0;
        
        Map<Integer,Integer> map = new HashMap<>();

        while(end<n){
            map.put(fruits[end],map.getOrDefault(fruits[end],0)+1);

            while(map.size()>=3)
            {   
                //reducing the frequency of start ele
                map.put(fruits[start],map.get(fruits[start])-1);

                // remove if the start ele is 0 freq i.e new ele and second ele are new eles
                if(map.get(fruits[start]) == 0) map.remove(fruits[start]);

                start++;
            }

            int currLen = end-start+1;

            maxLen = Math.max(maxLen,currLen);
            end++;

        }

        return maxLen;
    }
}