//给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素
// 。 
//
// 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 
//。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,1]
//输出: [2,-1,2]
//解释: 第一个 1 的下一个更大的数是 2；
//数字 2 找不到下一个更大的数； 
//第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3,4,3]
//输出: [2,3,4,-1,4]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 栈 数组 单调栈 👍 743 👎 0
package leetcode.editor.cn;

import java.util.Stack;

class NextGreaterElementIi {
    public static void main(String[] args) {
        Solution solution = new NextGreaterElementIi().new Solution();
        solution.nextGreaterElements(new int[]{1,2,3,2,1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int[] ans = new int[nums.length];
            // 循环2次 构建单调栈 存入的是下标 具体的值需要去数组里面取
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < nums.length; i++) {
                while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                    ans[stack.pop()] = nums[i];
                }
                stack.push(i);
            }
            // 循环查找第二次
            for (int i = 0; i < nums.length; i++) {
                while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                    ans[stack.pop()] = nums[i];
                }
            }
            while (!stack.isEmpty()) {
                Integer pop = stack.pop();
                ans[pop] = -1;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}