import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start
class Solution {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(toList(nums), 0);

        return ans;
    }

    public List<Integer> toList(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            list.add(num);
        }

        return list;
    }

    public void backtrack(List<Integer> nums, int pos) {
        if (pos == nums.size()) {
            ans.add(new ArrayList<>(nums));
        }

        // pos as start point for nums from pos to the end
        for (int i = pos; i < nums.size(); i++) {
            Collections.swap(nums, pos, i);

            backtrack(nums, pos + 1);

            Collections.swap(nums, pos, i);
        }
    }
}
// @lc code=end

