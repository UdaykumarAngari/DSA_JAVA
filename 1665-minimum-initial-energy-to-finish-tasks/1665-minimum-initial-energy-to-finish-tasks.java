class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> {
            return (b[1] - b[0]) - (a[1] - a[0]);
        });

        int sum = 0;
        int n = tasks.length;
        for (int i = 0; i < n; i++) {
            sum += tasks[i][1];
        }

        int st = 0, end = sum;

        while (st <= end) {
            int mid = (end - st) / 2 + st;
            if (check(mid, tasks)) {
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }

        return st;
    }

    private boolean check(int energy, int[][] tasks) {
        int n = tasks.length;
        for (int i = 0; i < n; i++) {
            if (tasks[i][1] > energy)
                return false;
            energy -= tasks[i][0];
        }
        return true;
    }
}