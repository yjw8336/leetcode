//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
//
// 例如：
//给定二叉树 [3,9,20,null,null,15,7],
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回锯齿形层序遍历如下：
//
//
//[
//  [3],
//  [20,9],
//  [15,7]
//]
//
// Related Topics 栈 树 广度优先搜索
// 👍 436 👎 0

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * [103]二叉树的锯齿形层序遍历
 */
class BinaryTreeZigzagLevelOrderTraversal {
    //leetcode submit region begin(Prohibit modification and deletion)

    // * Definition for a binary tree node.
    public class TreeNode {
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

        private List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null) {
                return result;
            }
            dfs(true, Collections.singletonList(root));
            return result;

        }

        private void dfs(boolean isLeft, List<TreeNode> nodes) {
            List<Integer> values = nodes.stream()
                    .filter(Objects::nonNull)
                    .map(treeNode -> treeNode.val)
                    .collect(Collectors.toList());
            if (!values.isEmpty()) {
                if (!isLeft) {
                    Collections.reverse(values);
                }
                result.add(values);
            }
            List<TreeNode> children = nodes.stream().flatMap(node -> Stream.of(node.left, node.right)).filter(Objects::nonNull).collect(Collectors.toList());
            if (!children.isEmpty()) {
                dfs(!isLeft, children);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();

//        Stream.of(-9, -3, 2, null, 4, 4, 0, -6, null, -5);
//        TreeNode treeNode1 = new TreeNode(-9);
//        TreeNode treeNode2 = new TreeNode(-3);
//        TreeNode treeNode3 = new TreeNode(2);
//        TreeNode treeNode4 = new TreeNode(4);
//        TreeNode treeNode5 = new TreeNode(4);
//        TreeNode treeNode6 = new TreeNode(0);
//        TreeNode treeNode7 = new TreeNode(-6);
//        TreeNode treeNode8 = new TreeNode(-5);
//
//        treeNode1.left = treeNode2;
//        treeNode1.right = treeNode3;
//        treeNode2.right = treeNode4;
//        treeNode3.left = treeNode5;
//        treeNode3.right = treeNode6;
//        treeNode4.left = treeNode7;
//        treeNode5.left = treeNode8;
//        solution.zigzagLevelOrder(treeNode1);

    }

}
