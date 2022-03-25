//给定一个整数 n ，返回 n! 结果中尾随零的数量。
//
// 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：0
//解释：3! = 6 ，不含尾随 0
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：1
//解释：5! = 120 ，有一个尾随 0
// 
//
// 示例 3： 
//
// 
//输入：n = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 104 
// 
//
// 
//
// 进阶：你可以设计并实现对数时间复杂度的算法来解决此问题吗？ 
// Related Topics 数学 
// 👍 579 👎 0

package leetcode.editor.cn;

class FactorialTrailingZeroes {
    public static void main(String[] args) {
        Solution solution = new FactorialTrailingZeroes().new Solution();
        System.out.println(solution.trailingZeroes(100));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int trailingZeroes(int n) {

            /**
             * 在阶乘中 只有和5相关的乘法才能产生0, 但是注意 25 可以分解为 5 * 5 而不是单纯的5的倍数, 50可以分解为 5 * 5 * 2
             */
            int ans = 0;
            while (n >= 5) {
                n /= 5;
                ans += n;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

