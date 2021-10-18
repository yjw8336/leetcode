//有个马戏团正在设计叠罗汉的表演节目，一个人要站在另一人的肩膀上。出于实际和美观的考虑，在上面的人要比下面的人矮一点且轻一点。已知马戏团每个人的身高和体重，请
//编写代码计算叠罗汉最多能叠几个人。
//
// 示例：
//
//
//输入：height = [65,70,56,75,60,68] weight = [100,150,90,190,95,110]
//输出：6
//解释：从上往下数，叠罗汉最多能叠 6 层：(56,90), (60,95), (65,100), (68,110), (70,150), (75,190)
//
//
// 提示：
//
//
// height.length == weight.length <= 10000
//
// Related Topics 数组 二分查找 动态规划 排序
// 👍 72 👎 0


import com.sun.tools.javac.util.Pair;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * [面试题 17.08]马戏团人塔
 */
class CircusTowerLcci {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int bestSeqAtIndex(int[] height, int[] weight) {
            List<Pair<Integer, Integer>> collect = IntStream.range(0, height.length - 1).mapToObj(i -> new Pair<>(height[i], weight[i]))
                    .sorted((o1, o2) -> Objects.equals(o1.fst, o2.fst) ? o2.snd - o1.snd : o1.fst - o2.fst).collect(Collectors.toList());
            System.out.println(collect);
            return 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new CircusTowerLcci().new Solution();
        solution.bestSeqAtIndex(new int[]{65, 70, 56, 75, 60, 68}, new int[]{100, 150, 90, 190, 95, 110});
    }

}
