//给你 root1 和 root2 这两棵二叉搜索树。请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root1 = [2,1,4], root2 = [1,0,3]
//输出：[0,1,1,2,3,4]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root1 = [1,null,8], root2 = [8,1]
//输出：[1,1,8,8]
// 
//
// 
//
// 提示： 
//
// 
// 每棵树的节点数在 [0, 5000] 范围内 
// -105 <= Node.val <= 105 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 排序 
// 👍 78 👎 0

package leetcode.editor.cn;

import domain.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class AllElementsInTwoBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new AllElementsInTwoBinarySearchTrees().new Solution();
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
        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {


            // 中序遍历二叉搜索树, 二叉搜索树中序遍历是递增的
            Deque<Integer> one = new ArrayDeque<>();
            Deque<Integer> two = new ArrayDeque<>();
            midLoop(one, root1);
            midLoop(two, root2);
            // 合并遍历结果(归并排序后半部分)
            return merge(one, two);

        }

        private List<Integer> merge(Deque<Integer> one, Deque<Integer> two) {
            List<Integer> ans = new ArrayList<>(one.size() + two.size());

            while (!one.isEmpty() || !two.isEmpty()) {
                if (!one.isEmpty() && !two.isEmpty()) {

                    if (one.peek() >= two.peek()) {
                        ans.add(two.poll());
                    } else {
                        ans.add(one.poll());
                    }
                    continue;
                }
                if (one.isEmpty()) {
                    ans.add(two.poll());
                    continue;
                }
                ans.add(one.poll());

            }

            return ans;
        }

        private void midLoop(Deque<Integer> ans, TreeNode root) {
            if (root == null) {
                return;
            }
            midLoop(ans, root.left);
            ans.add(root.val);
            midLoop(ans, root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

