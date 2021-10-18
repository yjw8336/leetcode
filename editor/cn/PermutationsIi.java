//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
//
//
// 示例 2：
//
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 8
// -10 <= nums[i] <= 10
//
// Related Topics 数组 回溯
// 👍 777 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [47]全排列 II
 */
class PermutationsIi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        private boolean[] vis;

        public List<List<Integer>> permuteUnique(int[] nums) {
            vis = new boolean[nums.length];
            Arrays.fill(vis, false);
            Arrays.sort(nums);
            backTrace(nums, new ArrayList<>());
            return result;

        }

        private void backTrace(int[] collect, ArrayList<Integer> integers) {
            if (collect.length == integers.size()) {
                result.add(new ArrayList<>(integers));
                return;
            }
            for (int i = 0; i < collect.length; i++) {
                Integer integer = collect[i];
                if (vis[i] || (i > 0 && (!vis[i - 1]) && collect[i] == collect[i - 1])) {
                    continue;
                }
                integers.add(integer);
                vis[i] = true;
                backTrace(collect, integers);
                vis[i] = false;
                integers.remove(integers.size() - 1);
            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution s = new PermutationsIi().new Solution();
        List<List<Integer>> lists = s.permuteUnique(new int[]{1, 2, 3});
        Solution s2 = new PermutationsIi().new Solution();
        List<List<Integer>> lists1 = s2.permuteUnique(new int[]{1, 1, 2});
        System.out.println(lists);
        System.out.println(1);
        System.out.println(lists1);
    }

}
