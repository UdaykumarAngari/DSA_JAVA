class Solution {

    public int minGroups(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> 
            Integer.compare(a[0], b[0])
        );

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] interval : intervals) {

            int start = interval[0];
            int end = interval[1];

            // Earliest group becomes free before this interval starts
            if (!pq.isEmpty() && pq.peek() < start) {
                pq.poll();
            }

            // Put current interval into a group
            pq.offer(end);
        }

        return pq.size();
    }
}