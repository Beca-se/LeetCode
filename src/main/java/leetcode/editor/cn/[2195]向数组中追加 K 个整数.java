//给你一个整数数组 nums 和一个整数 k 。请你向 nums 中追加 k 个 未 出现在 nums 中的、互不相同 的 正 整数，并使结果数组的元素和 最
//小 。 
//
// 返回追加到 nums 中的 k 个整数之和。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,4,25,10,25], k = 2
//输出：5
//解释：在该解法中，向数组中追加的两个互不相同且未出现的正整数是 2 和 3 。
//nums 最终元素和为 1 + 4 + 25 + 10 + 25 + 2 + 3 = 70 ，这是所有情况中的最小值。
//所以追加到数组中的两个整数之和是 2 + 3 = 5 ，所以返回 5 。 
//
// 示例 2： 
//
// 输入：nums = [5,6], k = 6
//输出：25
//解释：在该解法中，向数组中追加的两个互不相同且未出现的正整数是 1 、2 、3 、4 、7 和 8 。
//nums 最终元素和为 5 + 6 + 1 + 2 + 3 + 4 + 7 + 8 = 36 ，这是所有情况中的最小值。
//所以追加到数组中的两个整数之和是 1 + 2 + 3 + 4 + 7 + 8 = 25 ，所以返回 25 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// 1 <= nums[i], k <= 109 
// 
// Related Topics 贪心 数组 数学 排序 
// 👍 29 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

class AppendKIntegersWithMinimalSum {
    public static void main(String[] args) {
        Solution solution = new AppendKIntegersWithMinimalSum().new Solution();
        System.out.println(solution.minimalKSum(new int[]{1}, 100000000));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long minimalKSum(int[] nums, int k) {
          /*
          k的值太大 暴力会超时
          int length = nums.length;
            Map<Integer, Boolean> cache = new HashMap<>(length);
            for (int num : nums) {
                cache.put(num, true);
            }
            long ans = 0;
            length += k;
            for (int i = 1; i <= length; i++) {
                if (cache.containsKey(i)) {
                    continue;
                }
                if (--k < 0) {
                    break;
                }
                ans += i;
            }
            return ans;*/

            long ans = 0, left = 0, length = 0;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length && k > 0; i++) {
                // 可以补数据了
                if (left < nums[i]) {
                    length = nums[i] - left - 1;
                    // 如果中间的数据可以全部用来补
                    if (k < length) {
                        length = k;
                    }
                    ans += left * length + (length + 1) * length / 2;
                    k -= length;
                }
                left = nums[i];
            }
            // 如果补充的数据不够个数,继续补,这个时候left的值等于原数组中最大的值
            if (k > 0) {
                length = k;
                ans += left * length + (length + 1) * length / 2;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

