//给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// 
// 
// Related Topics 树 二叉搜索树 动态规划 回溯 二叉树 
// 👍 1174 👎 0

package leetcode.editor.cn;

import domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

class UniqueBinarySearchTreesIi {
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTreesIi().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<TreeNode> generateTrees(int n) {
            return generateTrees(1, n);
        }

        public List<TreeNode> generateTrees(int start, int end) {
            List<TreeNode> ans = new ArrayList<>();
            if (start > end) {
                // 方便后续的拼接
                ans.add(null);
                return ans;
            }
            if (start == end) {
                ans.add(new TreeNode(start));
                return ans;
            }
            // 依次选做主节点
            for (int i = start; i <= end; i++) {
                List<TreeNode> leftNodes = generateTrees(start, i - 1);
                List<TreeNode> rightNodes = generateTrees(i + 1, end);
                for (TreeNode left : leftNodes) {
                    for (TreeNode right : rightNodes) {
                        TreeNode currTree = new TreeNode(i);
                        currTree.left = left;
                        currTree.right = right;
                        ans.add(currTree);
                    }
                }

            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

