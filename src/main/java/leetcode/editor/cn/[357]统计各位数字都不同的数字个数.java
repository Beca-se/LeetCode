//给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10n 。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：91
//解释：答案应为除去 11、22、33、44、55、66、77、88、99 外，在 0 ≤ x < 100 范围内的所有数字。 
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：1
// 
// 
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 8 
// 
// Related Topics 数学 动态规划 回溯 
// 👍 215 👎 0

package leetcode.editor.cn;

class CountNumbersWithUniqueDigits {
    public static void main(String[] args) {
        Solution solution = new CountNumbersWithUniqueDigits().new Solution();
        System.out.println(solution.countNumbersWithUniqueDigits(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countNumbersWithUniqueDigits(int n) {
            /**
             *
             * 0   1
             * 1   9
             * 2   9 9
             * 3   9 9 8
             * 4   9 9 8 7
             * 5   9 9 8 7 6
             * 6   9 9 8 7 6 5
             * 7   9 9 8 7 6 5 4
             * 8   9 9 8 7 6 5 4 3
             */
            int ans = 1;
            int temp = 9;
            for (int i = 0; i < n; i++) {
                ans += temp;
                temp *= (9 - i);
            }
            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}

