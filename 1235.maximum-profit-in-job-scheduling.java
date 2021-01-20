import java.util.Arrays;
import java.util.TreeMap;

/*
 * @lc app=leetcode id=1235 lang=java
 *
 * [1235] Maximum Profit in Job Scheduling
 */

// @lc code=start
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        int[][] jobs = new int[n][3];

        for (int i = 0; i < n; i++) {
            jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }

        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);

        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0, 0);

        for (int[] job : jobs) {
            int cur = job[2] + dp.floorEntry(job[0]).getValue();

            if (cur > dp.lastEntry().getValue()) {
                dp.put(job[1], cur);
            }
        }

        return dp.lastEntry().getValue();
    }
}
// @lc code=end

