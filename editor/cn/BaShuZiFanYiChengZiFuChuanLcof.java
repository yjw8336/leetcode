//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
//
//
//
// 示例 1:
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
//
//
//
// 提示：
//
//
// 0 <= num < 231
//
// Related Topics 字符串 动态规划
// 👍 267 👎 0

/**
 * [剑指 Offer 46]把数字翻译成字符串
 */
class BaShuZiFanYiChengZiFuChuanLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int translateNum(int num) {
            String src = String.valueOf(num);
            int tmp = 0, q = 0, result = 1;
            for (int i = 0; i < src.length(); ++i) {
                tmp = q;
                q = result;
                result = q;
                if (i == 0) {
                    continue;
                }
                String pre = src.substring(i - 1, i + 1);
                if (pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0) {
                    result += tmp;
                }
            }
            return result;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new BaShuZiFanYiChengZiFuChuanLcof().new Solution();
        int i = solution.translateNum(220);
        System.out.println(i);
    }

}
