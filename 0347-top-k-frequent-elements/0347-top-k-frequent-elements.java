class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for (int key : map.keySet()) {
            pq.add(key);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] res = new int[pq.size()];

        int i = 0;
        while(!pq.isEmpty()){
            res[i++] = pq.poll();
        }
        return res;
    }

}