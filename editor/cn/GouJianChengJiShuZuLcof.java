//给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[
//i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
//
//
//
// 示例:
//
//
//输入: [1,2,3,4,5]
//输出: [120,60,40,30,24]
//
//
//
// 提示：
//
//
// 所有元素乘积之和不会溢出 32 位整数
// a.length <= 100000
//
// Related Topics 数组 前缀和
// 👍 142 👎 0

import java.util.Arrays;

/**
 * [剑指 Offer 66]构建乘积数组
 */
class GouJianChengJiShuZuLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] constructArr(int[] a) {
            int len = a.length;
            if (len == 0) return new int[0];
            int[] b = new int[len];
            b[0] = 1;
            int tmp = 1;
            for (int i = 1; i < len; i++) {
                b[i] = b[i - 1] * a[i - 1];
            }
            System.out.println(Arrays.toString(b));
            for (int i = len - 2; i >= 0; i--) {
                tmp *= a[i + 1];
                b[i] *= tmp;
            }
            System.out.println(Arrays.toString(b));
            return b;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new GouJianChengJiShuZuLcof().new Solution();
        solution.constructArr(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
    }

}
