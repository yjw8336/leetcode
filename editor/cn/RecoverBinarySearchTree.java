//给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
//
// 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？
//
//
//
// 示例 1：
//
//
//输入：root = [1,3,null,null,2]
//输出：[3,1,null,null,2]
//解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
//
//
// 示例 2：
//
//
//输入：root = [3,1,4,null,null,2]
//输出：[2,1,4,null,null,3]
//解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。
//
//
//
// 提示：
//
//
// 树上节点的数目在范围 [2, 1000] 内
// -231 <= Node.val <= 231 - 1
//
// Related Topics 树 深度优先搜索
// 👍 451 👎 0

import java.util.ArrayList;

/**
 * [99]恢复二叉搜索树
 */
class RecoverBinarySearchTree {
    //leetcode submit region begin(Prohibit modification and deletion)


    //  deletionDefinition for a binary tree node.
    public  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public void recoverTree(TreeNode root) {
            if (root == null) {
                return;
            }
            if (root.right != null) {
                if (root.val < root.right.val) {
                    exchangeValue(root, root.right);
                    recoverTree(root);
                }
            }
            if (root.left != null) {
                if (root.left.val > root.val) {
                    exchangeValue(root, root.left);
                    recoverTree(root);
                }
            }


            recoverTree(root.left);
            recoverTree(root.right);
        }

        private void exchangeValue(TreeNode node1, TreeNode node2) {
            int tmp = node1.val;
            node1.val = node2.val;
            node2.val = tmp;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
//        Solution solution = new RecoverBinarySearchTree().new Solution();
//        TreeNode treeNode1 = new TreeNode(3);
//        TreeNode treeNode2 = new TreeNode(1);
//        TreeNode treeNode3 = new TreeNode(2);
//        treeNode2.left = treeNode1;
//        treeNode1.right = treeNode3;
////        solution.recoverTree(treeNode2);
//        treeNodeToArray(treeNode2);
//        System.out.println(result);
    }

    static ArrayList<Integer> result = new ArrayList<>();


    private static void treeNodeToArray(TreeNode root) {
        if (root == null) {
            result.add(null);
            return;
        }
        result.add(root.val);
        treeNodeToArray(root.left);
        treeNodeToArray(root.right);

    }
}
