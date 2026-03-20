class Solution {
    public int[][] merge(int[][] intervals) {
        //Arrays.sort(intervals, (a,b) -> a[0]-b[0]);

        List<int[]> list = new ArrayList<>();
        int n = intervals.length;
        int i = 0;

        //optimal
       // Step 1: Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int[] interval : intervals) {

            if (list.isEmpty() || list.get(list.size() - 1)[1] < interval[0]) {
                // No overlap
                list.add(interval);
            } else {
                // Overlap → merge
                list.get(list.size() - 1)[1] =
                    Math.max(list.get(list.size() - 1)[1], interval[1]);
            }
        }

        //brute force

        // while(i<n){
        //     int start =  intervals[i][0];
        //     int end = intervals[i][1];

        //     int j = i + 1;
        //     while(j<n && intervals[j][0] <= end){
        //         end = Math.max(end, intervals[j][1]);
        //         j++;
        //     }
        //     list.add(new int[]{start,end});
        //     i=j;
        // }
        return list.toArray(new int[list.size()][]);
        
    }
}