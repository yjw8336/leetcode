//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
// 示例 2：
//
//
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
//
//
// 示例 3：
//
//
//输入：nums = [1]
//输出：[[1]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 6
// -10 <= nums[i] <= 10
// nums 中的所有整数 互不相同
//
// Related Topics 数组 回溯
// 👍 1507 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [46]全排列
 */
class Permutations {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] vis;

        public List<List<Integer>> permute(int[] nums) {
            vis = new boolean[nums.length];
            Arrays.fill(vis, false);
            backTrace(nums, new ArrayList<Integer>());
            return result;
        }

        private void backTrace(int[] nums, ArrayList<Integer> index) {
            if (nums.length == index.size()) {
                result.add(new ArrayList<>(index));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (vis[i]) {
                    continue;
                }
                vis[i] = true;
                index.add(num);
                backTrace(nums, index);
                vis[i] = false;
                index.remove(index.size() - 1);

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution s = new Permutations().new Solution();
        List<List<Integer>> permute = s.permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }

}
