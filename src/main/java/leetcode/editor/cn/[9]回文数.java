//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。 
//
// 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 121
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：x = -121
//输出：false
//解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3： 
//
// 
//输入：x = 10
//输出：false
//解释：从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 示例 4： 
//
// 
//输入：x = -101
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
//
// 
//
// 进阶：你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学 
// 👍 1497 👎 0


package leetcode.editor.cn;

class PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new PalindromeNumber().new Solution();
        System.out.println(solution.isPalindrome(10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {
            // 字符串直接翻转比较 字符串双指针
            // 负数不可能是回文数.以0结尾的数,除了0 都不是回文数
            if (x < 0 || (x % 10 == 0 && x != 0)) {
                return false;
            }
            int res = 0;
            while (res < x) {
                res = res * 10 + x % 10;
                x /= 10;
            }
            // 如果长度是偶数,是回文数字的话 翻转后 res==x,如果是奇数,翻转后res会比x多一位,我们不比较最后一位
            return res == x || res / 10 == x;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
  