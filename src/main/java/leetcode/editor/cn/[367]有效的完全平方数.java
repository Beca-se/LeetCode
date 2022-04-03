//给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
//
// 进阶：不要 使用任何内置的库函数，如 sqrt 。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 16
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：num = 14
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 2^31 - 1 
// 
// Related Topics 数学 二分查找 
// 👍 362 👎 0

package leetcode.editor.cn;

class ValidPerfectSquare {
    public static void main(String[] args) {
        Solution solution = new ValidPerfectSquare().new Solution();
        System.out.println(solution.isPerfectSquare(808201));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPerfectSquare(int num) {

            //   num==1+3+5+...+(2∗n−1)
//            int base = 1;
//            while (num > 0) {
//                num -= base;
//                base += 2;
//            }
//            return num == 0;

            // 利用二分查找
            int left = 0, right = num / 2 + 1;
            long mid;
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (mid * mid == num) {
                    return true;
                }
                if (mid * mid > num) {
                    right = (int) mid - 1;
                } else {
                    left = (int) mid + 1;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

